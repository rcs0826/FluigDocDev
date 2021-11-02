/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev.entidades;

/**
 * * Bibliotecas para escrita **
 */
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
/**
 * * Bibliotecas para Leitura **
 */
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;

import fluigdocdev.entidades.Cliente;
import fluigdocdev.entidades.Projeto;
import fluigdocdev.entidades.ArqProjet;
import fluigdocdev.FileText;
import fluigdocdev.SqliteConnect;
import gui.ava.html.image.generator.HtmlImageGenerator;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import org.apache.poi.util.Units;

/**
 * *********************************************************************
 */
import org.apache.poi.*;
import org.apache.poi.ooxml.*;
import org.apache.poi.openxml4j.opc.*;

import org.apache.poi.xwpf.usermodel.*;

/**
 * *********************************************************************
 */
/**
 *
 * @author rogerio
 */
public class DocPoi {

    private Cliente cliente = new Cliente();
    private Projeto projeto = new Projeto();
    private ArqProjet arquivo = new ArqProjet();
    private SqliteConnect sql = new SqliteConnect();
    private FileText fileText = new FileText();
    
    private String fontFamily = "Arial";

    /**
     * *********************************************
     * Método Principal 
     * *********************************************
     */
    public void setInfoDoc(String param, String cli, String proj, Boolean listAllDoc) {
        try {
            this.projeto.setDescricao(proj);
            String idProj = this.sql.getUnicValue(this.projeto.getSelIdProj());
            String query = "Select * from ArquivosProjeto where idProj = " + idProj + " and tipoFluig = '?'";

            //DefaultTableModel model = this.sql.getResultTableModel(query.replace("?", "workflow"));
            XWPFDocument document = new XWPFDocument();

            // Titulo
            this.setTitle(document, "Projeto " + proj + "\r\nCliente " + cli);
            this.getParagrafFile(document, "Processo", query.replace("?", "workflow"),true,false);
            this.getParagrafFile(document, "Formulários", query.replace("?", "forms"),listAllDoc,false);
            this.getParagrafFile(document, "Datasets", query.replace("?", "datasets"),true,false);
            this.getParagrafFile(document, "WCM", query.replace("?", "wcm"),listAllDoc,false);
            this.getParagrafFile(document, "Template de E-mail", query.replace("?", "templateemail"),false,false);
            this.getParagrafFile(document, "Querys", query.replace("?", "query"),true,true);  
            this.getParagrafFile(document, "Anotações Extra", query.replace("?", "doc"),listAllDoc,true);

            // Criar e gravar os dados no arquivo Word *************************************************
            FileOutputStream out = new FileOutputStream(param);
            document.write(out);
            out.close();
            document.close();
            System.out.printf("Arquivo %s gerado",param);

        } catch (Exception e) {
            System.err.printf("Erro Main %s: ",e.getMessage());
        }
    }
    
    /* Título */
    private void setTitle(XWPFDocument document, String texto) {
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText(texto);
        titleRun.setColor("990600");
        titleRun.setBold(true);
        titleRun.setFontFamily(this.fontFamily);
        titleRun.setFontSize(20);
        titleRun.addBreak();
    }

    /* Subtítulo */
    private void setSubTitle(XWPFDocument document, String texto) {
        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.addBreak();
        subTitleRun.setText(texto);
        subTitleRun.setColor("232F8D");
        subTitleRun.setFontFamily(this.fontFamily);
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
        //subTitleRun.addBreak();
    }

    /* Paragrafo */
    private void setParag(XWPFDocument document, String texto, boolean negr) {
        XWPFParagraph parag = document.createParagraph();
        parag.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun paragRun = parag.createRun();
        paragRun.setText(texto);
        paragRun.setColor("000000");
        paragRun.setFontFamily(this.fontFamily);
        paragRun.setFontSize(10);        
        paragRun.setBold(negr);        
    }
    
    /* Traz os nomes dos diretórios e arquivos */
    private void getParagrafFile(XWPFDocument document, String title, String query, Boolean list, Boolean read) throws SQLException {
        DefaultTableModel model = this.sql.getResultTableModel(query);

        if (model.getRowCount() != 0) {
            this.setSubTitle(document, title);
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            Vector vet = (Vector) model.getDataVector().get(i);
            if(vet.get(3).toString().equals("dir") && list){
                this.setParag(document, this.fileText.getFiles(vet.get(4).toString()),false);
            }
            else{
                if(read){
                    this.setParag(document, this.fileText.getReader(vet.get(4).toString()),false);
                }
                else{
                    String arq[] = vet.get(1).toString().replace(".","#").split("#");
                    this.setParag(document, arq[0].toString(),false);
                    //if(arq[1].toString().equals("html")){
                    if(title.equals("Formulários") || title.equals("Processo")){
                       // this.convertHTMLtoIMG(arq[0].toString(),this.fileText.getReader(vet.get(4).toString()));
                    }
                }
            }
        }
    }
 /****************************************************************************************************
  ************************* Daqui para baixo só é testes *********************************************
  ****************************************************************************************************/
    
    private void setImage(XWPFDocument document, String localimg) {
        XWPFParagraph image = document.createParagraph();
        localimg = "/home/rogerio/Imagens/logistica-transporte-mercadoria-coleta-agendada-jacarei-destaque-2.jpg";
        image.setAlignment(ParagraphAlignment.CENTER);
        System.out.println("localimg: " + localimg);
        XWPFRun imageRun = image.createRun();
        imageRun.setTextPosition(20);

        try {
            Path imagePath = Paths.get(ClassLoader.getSystemResource(localimg).toURI());
            imageRun.addPicture(Files.newInputStream(imagePath),
            XWPFDocument.PICTURE_TYPE_JPEG, imagePath.getFileName().toString(),
            Units.toEMU(50), Units.toEMU(50));
        } catch (Exception e) {
            System.err.println("Erro img: " + e.getMessage());
        }
    }

    private void convertHTMLtoIMG(String arquivo, String texto) {
        try {
            String html = "<body lang=PT-BR style='tab-interval:35.4pt'><img src='http://nxcache.nexon.net/all/v1.5.2/img/gnt/games-dropdown/maplestory.jpg'></body>";
            /*
            HtmlImageGenerator hig = new HtmlImageGenerator();
            hig.loadHtml(texto);
            hig.saveAsImage(new File("/home/rogerio/Downloads/"+arquivo+".png"));
            */
            int width = 600, height = 200;

            BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);

            Graphics graphics = image.createGraphics();

            JEditorPane jep = new JEditorPane("text/html", texto);
            jep.setSize(width, height);
            jep.print(graphics);
            ImageIO.write(image, "png", new File("/home/rogerio/Downloads/"+arquivo+".png"));
            //return hig;

        } catch (Exception ex) {
            System.err.println("Erro 2: " + ex.getMessage());
        }
        //return null;
    }    

    private static MyXWPFHtmlDocument createHtmlDoc(XWPFDocument document, String id) throws Exception {
        OPCPackage oPCPackage = document.getPackage();
        PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
        PackagePart part = oPCPackage.createPart(partName, "text/html");
        MyXWPFHtmlDocument myXWPFHtmlDocument = new MyXWPFHtmlDocument(part, id);
        document.addRelation(myXWPFHtmlDocument.getId(), new XWPFHtmlRelation(), myXWPFHtmlDocument);
        return myXWPFHtmlDocument;
    }

    private static class MyXWPFHtmlDocument extends POIXMLDocumentPart {

        private String html;
        private String id;

        private MyXWPFHtmlDocument(PackagePart part, String id) throws Exception {
            super(part);
            this.html = "<!DOCTYPE html><html><head><style></style><title>HTML import</title></head><body></body>";
            this.id = id;
        }

        private String getId() {
            return id;
        }

        private String getHtml() {
            return html;
        }

        private void setHtml(String html) {
            this.html = html;
        }

        @Override
        protected void commit() throws IOException {
            PackagePart part = getPackagePart();
            OutputStream out = part.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write(html);
            writer.close();
            out.close();
        }

    }

    //the XWPFRelation for /word/htmlDoc#.html
    private final static class XWPFHtmlRelation extends POIXMLRelation {

        private XWPFHtmlRelation() {
            super(
                    "text/html",
                    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
                    "/word/htmlDoc#.html");
        }
    }
}
