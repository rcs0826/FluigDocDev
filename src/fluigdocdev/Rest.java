/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluigdocdev;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 *
 * @author rogerio
 */
public class Rest {
    private static XMLSoapFluig xml = new XMLSoapFluig();

public static void postRest(String url) throws Exception {
     url = "https://hmlportal.santher.com.br/webdesk/ECMDatasetService";
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);

    String json = xml.getAvailableDatasets(1, "alexandre.mendes@santher.com.br", "santher@00");
    StringEntity entity = new StringEntity(json);
    httpPost.setEntity(entity);
    httpPost.setHeader("Accept", "application/xml");
    httpPost.setHeader("Content-type", "application/xml");

    CloseableHttpResponse response = client.execute(httpPost);
     int code = response.getStatusLine().getStatusCode();
     System.out.println("Response post code--> " + code);
    client.close();
}
    public static void postRest2(String url) throws Exception {
     url = "https://hmlportal.santher.com.br/webdesk/ECMDatasetService";
     HttpClient client = new DefaultHttpClient();
        System.out.println("0");
     HttpPost httpPost = new HttpPost(url);
        System.out.println("1");
     /*
     List<NameValuePair> params = new ArrayList<NameValuePair>();
     params.add(new BasicNameValuePair("companyId", "1"));
     params.add(new BasicNameValuePair("username", "alexandre.mendes@santher.com.br"));
     params.add(new BasicNameValuePair("password", "santher@00"));
     httpPost.setEntity(new UrlEncodedFormEntity(params));
     */
     String input = xml.getAvailableDatasets(1, "alexandre.mendes@santher.com.br", "santher@00");
        System.out.println("2 "+input);
     StringEntity entity = new StringEntity(input, org.apache.http.entity.ContentType.TEXT_XML);
        System.out.println("3");
     
     //httpPost.setEntity(new UrlEncodedFormEntity(entity));
    httpPost.setEntity(entity);
    httpPost.setHeader("Accept", "application/xml");
    httpPost.setHeader("Content-type", "application/xml");

        System.out.println("4");
     HttpResponse response = client.execute(httpPost);
     System.out.println("Response post response--> " + response);
     int code = response.getStatusLine().getStatusCode();
     System.out.println("Response post code--> " + code);
     
     try (BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));) {
            // Read in all of the post results into a String.
            String output = "";
            Boolean keepGoing = true;
            while (keepGoing) {
                String currentLine = br.readLine();

                if (currentLine == null) {
                    keepGoing = false;
                } else {
                    output += currentLine;
                    System.out.println(currentLine);
                }
            }
            //System.out.println("Response post --> " + output);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        
    }
    public static void getRest(String url) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request1 = new HttpGet(url);
        HttpResponse response1 = client.execute(request1);
        int code = response1.getStatusLine().getStatusCode();

        try (BufferedReader br = new BufferedReader(new InputStreamReader((response1.getEntity().getContent())));) {
            // Read in all of the post results into a String.
            String output = "";
            Boolean keepGoing = true;
            while (keepGoing) {
                String currentLine = br.readLine();

                if (currentLine == null) {
                    keepGoing = false;
                } else {
                    output += currentLine;
                }
            }
            System.out.println("Response code--> " + code);
            System.out.println("Response--> " + output);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}
