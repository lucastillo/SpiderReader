/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiderreader;

import java.net.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

     public static void scrapeTopic(String url) {
        String html = getUrl( url);
        Document doc = Jsoup.parse(html);
        String contentText = doc.select("p").first().text();
        System.out.println(contentText);
    }

    public static String getUrl(String url) {
        URL urlObj = null;
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {
            System.out.println("The url was malformed!");
            return "";
        }
        URLConnection urlCon = null;
        BufferedReader in = null;
        String outputText = "";
        try {
            urlCon = urlObj.openConnection();
            in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                outputText += line;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("There was an error connecting to the URL");
            return "";
        }
        return outputText;
    }
    
    public static void main(String[] args) {
        scrapeTopic("http://www.nacion.com/deportes/atletismo/Sol_y_Arena-Puntarenas-atletismo_0_1482051914.html");
    }

   

}
