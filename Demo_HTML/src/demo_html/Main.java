/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_html;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author PhamChiHung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //loadAllDataFromFileXml();
        //findByAttr("S0101");
        //findByElementName("Nguyen Van A");
        filterByElementAge("20");
    }

    private static void loadAllDataFromFileXml() {
        try {
            //1. Load all data from file studentData.xml
            org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("studentData.xml");
            XPath newXPath = XPathFactory.newInstance().newXPath();
            NodeList lstStu = (NodeList) newXPath.evaluate("//students/student",dc, XPathConstants.NODESET);
            for (int i = 0; i<lstStu.getLength(); i++)
            {
                NamedNodeMap attributes = lstStu.item(i).getAttributes();
                NodeList childNodes = lstStu.item(i).getChildNodes();
                System.out.println("Student number: "+(i+1));
                System.out.println("Rollnumber: "+attributes.item(0).getTextContent()+"\tAddress: "+childNodes.item(3).getTextContent()+"\tAge: "+childNodes.item(5).getTextContent());
                System.out.println("------------------------------\n");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void findByAttr(String rollNumber) {
        try {
            //2. find element by attr
            org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("studentData.xml");
            XPath newXPath = XPathFactory.newInstance().newXPath();
            Element lstStu = (Element) newXPath.evaluate("//students/student[@rollNumber='"+rollNumber+"']",dc, XPathConstants.NODE);
            
            NamedNodeMap attributes = lstStu.getAttributes();
            NodeList childNodes = lstStu.getChildNodes();
            System.out.println("Find Student by rollnumber: " + rollNumber);
            System.out.println("Rollnumber: " + attributes.item(0).getTextContent() + "\tAddress: " + childNodes.item(3).getTextContent() + "\tAge: " + childNodes.item(5).getTextContent());
            System.out.println("------------------------------\n");

            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void findByElementName(String name) {
        try {
            //2. find element by attr
            org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("studentData.xml");
            XPath newXPath = XPathFactory.newInstance().newXPath();
            Element lstStu = (Element) newXPath.evaluate("//students/student[name='"+name+"']",dc, XPathConstants.NODE);
            
            NamedNodeMap attributes = lstStu.getAttributes();
            NodeList childNodes = lstStu.getChildNodes();
            System.out.println("Find Student by name: " + name);
            System.out.println("Rollnumber: " + attributes.item(0).getTextContent() + "\tAddress: " + childNodes.item(3).getTextContent() + "\tAge: " + childNodes.item(5).getTextContent());
            System.out.println("------------------------------\n");

            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void filterByElementAge(String age) {
        try {
            //2. find element by attr
            org.w3c.dom.Document dc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("studentData.xml");
            XPath newXPath = XPathFactory.newInstance().newXPath();
            Element lstStu = (Element) newXPath.evaluate("//students/student[age>='"+age+"']",dc, XPathConstants.NODE);
            
            NamedNodeMap attributes = lstStu.getAttributes();
            NodeList childNodes = lstStu.getChildNodes();
            System.out.println("Filter All Student age > " + age);
            System.out.println("Rollnumber: " + attributes.item(0).getTextContent() + "\tAddress: " + childNodes.item(3).getTextContent() + "\tAge: " + childNodes.item(5).getTextContent());
            System.out.println("------------------------------\n");

            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
