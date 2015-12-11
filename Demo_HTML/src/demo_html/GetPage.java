/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/**
 *
 * @author PhamChiHung
 */
public class GetPage {
    public static void main(String[] args){
        String link = "http://news.zing.vn";
        
        URL url;
        String content ="";
        try{
                url = new URL(link);
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		char[] buffer = new char[8192];
		int read = 0;
		StringBuilder sb = new StringBuilder();
		
		while ((read = reader.read(buffer)) != -1)
			sb.append(buffer, 0, read);
                
		content =  sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(content);
        //--------------------------------------
        //loadContentFromWeb();
    }
    
    private static void loadContentFromWeb(){
        try {
            //1. Load all data from file studentData.xml
          
            //org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(link);
            org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("test.xml");
            XPath newXPath = XPathFactory.newInstance().newXPath();
            NodeList lstStu = (NodeList) newXPath.evaluate("//site/expressions/expression/content",dc, XPathConstants.NODESET);
            for (int i = 0; i<lstStu.getLength(); i++)
            {
                NamedNodeMap attributes = lstStu.item(i).getAttributes();
                NodeList childNodes = lstStu.item(i).getChildNodes();
                //System.out.println("Rollnumber: "+attributes.item(0).getTextContent()+"\tAddress: "+childNodes.item(3).getTextContent()+"\tAge: "+childNodes.item(5).getTextContent());
                System.out.println("Noi dung trang web: " + attributes.item(0).getTextContent() + attributes.item(1).getTextContent() + attributes.item(2).getTextContent());
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
