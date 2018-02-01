/**
 * Project Name:lession1
 * File Name:DomXMLReader.java
 * Package Name:lession15
 * Date:2018年1月12日下午12:08:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhangxingyu.homework20180112;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午12:08:56 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see 11.1. 编写xml文件 ，存放学校班级信息，班级下面包括学员信息
 */
public class DomXMLReader {
    private final static Logger LOG = Logger.getLogger(DomXMLReader.class);

    public static void main(String[] args) {
        File f = new File("E:\\workspace\\lession1\\lession15\\Txt.xml");
        NodeList n1 = null;
        NodeList childList = null;
        Node node = null;
        Node fNode = null;
        String no = null;
        DocumentBuilderFactory factory = null;
        DocumentBuilder bulider = null;
        Document doc = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            bulider = factory.newDocumentBuilder();
            doc = bulider.parse(f);
            n1 = doc.getElementsByTagName("txt");
            for (int i = 0; i < n1.getLength(); i++) {
                // childList = doc.getElementsByTagName("class");
                // String nodeVel = el.getNodeValue();
                // node = childList.item(i);
                // fNode = node.getFirstChild();
                // no = fNode.getNodeValue();
                Element el = doc.getDocumentElement();
                String attr = el.getAttribute("banji");
                LOG.info("班级：" + attr);

                childList = doc.getElementsByTagName("name");
                node = childList.item(i);
                fNode = node.getFirstChild();
                no = fNode.getNodeValue();
                LOG.info("姓名:" + no);

                // childList = doc.getElementsByTagName("sex");
                // node = childList.item(i);
                // fNode = node.getFirstChild();
                // no = fNode.getNodeValue();
                LOG.info("性别:" + doc.getElementsByTagName("sex").item(i).getFirstChild().getNodeValue());
                LOG.info(" ");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        } catch (SAXException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
