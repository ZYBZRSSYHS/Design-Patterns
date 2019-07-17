package cn.DesignPatternBuilder;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

class ReadXML {
    public static Object getObject(){
        try{
            DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dfactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));
            NodeList nl = ((org.w3c.dom.Document) doc).getElementsByTagName("className");
            Node classNode =nl.item(0).getFirstChild();
            String cName = "Builder."+classNode.getNodeValue();
            System.out.println("新类："+cName);
            Class<?> c= Class.forName(cName);
            Object obj = c.newInstance();
            return obj;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
