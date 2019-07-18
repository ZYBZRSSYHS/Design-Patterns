package cn.DesignPatternAdapter;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class ReadXML {

    public static Object getObject(){
        try{
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\Test\\src\\main\\java\\cn\\DesignPatternAdapter\\config.xml"));

            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "DesignPatternAdapter."+classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
                Object obj = c.newInstance();
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
