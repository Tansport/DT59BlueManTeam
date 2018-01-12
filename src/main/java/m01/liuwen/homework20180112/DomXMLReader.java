/**
 * Project Name:DT59BlueManTeam
 * File Name:DomXMLReader.java
 * Package Name:m01.liuwen.homework20180112
 * Date:2018年1月12日下午2:17:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liuwen.homework20180112;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:17:53 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class DomXMLReader {

    public static void main(String[] args) {
        try {
            // 得到DOM解析器的工厂实例
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 从DOM工厂获得DOM解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 解析XML文档，得到一个Document对象，即DOM树
            Document doc = db.parse(
                    new File("E:\\git\\DT59BlueManTeam\\src\\main\\java\\m01\\liuwen\\homework20180112\\School.xml"));
            // 得到所有student节点列表信息
            NodeList nl = doc.getElementsByTagName("student");
            // 循环student信息
            for (int i = 0; i < nl.getLength(); i++) {
                // Element e = (Element) nl.item(i);
                // String str = e.getAttribute("id");
                // System.out.println(str);
                NodeList childList = doc.getElementsByTagName("name");
                Node elementNode = childList.item(i);
                Node textNode = elementNode.getFirstChild();
                String name = textNode.getNodeValue();

                NodeList childList1 = doc.getElementsByTagName("age");
                Node elementNode1 = childList1.item(i);
                Node textNode1 = elementNode1.getFirstChild();
                String age = textNode1.getNodeValue();

                NodeList childList2 = doc.getElementsByTagName("sex");
                Node elementNode2 = childList2.item(i);
                Node textNode2 = elementNode2.getFirstChild();
                String sex = textNode2.getNodeValue();

                System.out.println("姓名： " + name + '\t' + "年龄： " + age + "\t" + "性别： " + sex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
