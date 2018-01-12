/**
 * Project Name:homework
 * File Name:DomXMLReader.java
 * Package Name:DomXML
 * Date:2018年1月12日下午12:01:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package DomXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午12:01:15 <br/>
 * 
 * @author Zhengheyang
 * @version
 * @see
 */
public class DomXMLReader {
    public static void main(String[] args) {
        try {
            SAXReader sax = new SAXReader();
            FileInputStream fin = new FileInputStream(new File("D:\\Git_coid\\doc\\case\\Z2018_1_12\\pet.XML"));
            Document doc = sax.read(fin);
            Element ele = doc.getRootElement();
            String str = ele.getName();
            System.out.println(str);
            @SuppressWarnings("unchecked")
            List<Element> list = ele.elements();
            for (Element element : list) {
                System.out.println(element.attributeValue("name") + "\t" + element.getText());
                System.out.println(element.element("name").getText());
                System.out.println(element.element("price").getText());
                System.out.println(element.element("language").getText());
            }
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
