/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_html;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author PhamChiHung
 */
public class TutUrlGetContent {
    public static void main(String[] args){
        String link = "http://dantri.com.vn";
        
        URL url;
        String content = "";
        try{
            url = new URL(link);
            
            URLConnection connection = url.openConnection();
            
            InputStream inputStream = connection.getInputStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            
            String line = br.readLine();
            
            
            while (line != null){
                content = content + line;
                line = br.readLine();
                
            
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println(content);
    }
}
