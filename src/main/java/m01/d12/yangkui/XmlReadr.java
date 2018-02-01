/**
 * Project Name:DT59BlueManTeam
 * File Name:XmlReadr.java
 * Package Name:m01.yangkui.homework20180112
 * Date:2018年1月12日下午2:19:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.yangkui.homework20180112;

import java.io.File;

//import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import m01.yangkui.homework20180112.XmlReadr;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:19:20 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class XmlReadr {
    private final static Logger LOG = Logger.getLogger(XmlReadr.class);

    public static void main(String arge[]) {

        try {
            File f = new File("D:\\git\\DT59BlueManTeam1\\src\\main\\java\\m01\\yangkui\\homework20180112\\NewFile.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList nl = doc.getElementsByTagName("studen");
            for (int i = 0; i < nl.getLength(); i++) {
                Node school = nl.item(i);
                Element element = (Element) school;
                String at = element.getAttribute("classes");
                String at1 = element.getAttribute("name");
                String at2 = element.getAttribute("age");
                String at3 = element.getAttribute("sex");
                NodeList age = element.getChildNodes();
                LOG.info(at + at1 + at2 + at3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
