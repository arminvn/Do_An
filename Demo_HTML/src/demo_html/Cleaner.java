/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_html;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.SimpleHtmlSerializer;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 *
 * @author PhamChiHung
 */
public class Cleaner {
    public static Cleaner sInstance;

    public static Cleaner getInstance() {
        if (sInstance == null) {
            sInstance = new Cleaner();
        }
        return sInstance;
    }
    protected HtmlCleaner mCleaner;

//    public Cleaner() {
//        mCleaner = new HtmlCleaner();
//        CleanerProperties props = mCleaner.getProperties();
//        props.setAllowHtmlInsideAttributes(false);
//        props.setAllowMultiWordAttributes(true);
//        props.setRecognizeUnicodeChars(true);
//        props.setOmitComments(true);
//    }
    
    public static void main(String[] args) throws MalformedURLException, IOException{
       
        String content = "http://www.google.com.vn/";
        
        String siteUrl = "http://www.google.com.vn/";
        try{
            HtmlCleaner htmlCleaner = null;
            TagNode root = htmlCleaner.clean(siteUrl);
            htmlCleaner.getInnerHtml(root);
        //TagNode node = cleaner.clean(new URL(siteUrl));

        // serialize to xml file
        SimpleHtmlSerializer serializer = new SimpleHtmlSerializer(htmlCleaner.getProperties());
        serializer.writeToFile(root, "C:/cleaned.html");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
