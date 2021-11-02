/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

/**
 *
 * @author rogerio
 */
public class XMLSoapFluig {
    public static String getUrlECMDatasetService(String url){
        return url+"/webdesk/ECMDatasetService";
    }
    public static String getAvailableDatasets(int companyId, String username, String password){
        StringBuilder sb = new StringBuilder();
        sb.append("<soapenv:Envelopexmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"xmlns:ws=\"http://ws.dataservice.ecm.technology.totvs.com/\">");
        sb.append("<soapenv:Header/><soapenv:Body><ws:getAvailableDatasets>");
        sb.append("<companyId>");
        sb.append(companyId);
        sb.append("</companyId>");
        sb.append("<username>");
        sb.append(username);
        sb.append("</username>");
        sb.append("<password>");
        sb.append(password);
        sb.append("</password>");
        sb.append("</ws:getAvailableDatasets></soapenv:Body></soapenv:Envelope>");
        return sb.toString();
    }
}
