/**
 * Project Name:DT59BlueManTeam
 * File Name:SchoolDemo.java
 * Package Name:m01.liutao.homework20180112
 * Date:2018年1月12日下午3:21:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liutao.homework20180112;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午3:21:47 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class SchoolDemo {
    private final static Logger LOG = Logger.getLogger(SchoolDemo.class);

    public static void main(String[] args) {
        File file = new File("D:\\git\\DT59BlueManTeam\\src\\main\\java\\m01\\liutao\\homework20180112\\SchoolFile.xml");// 文件实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// 实例工厂对象
        DocumentBuilder db = null;// 文件加工对象实例
        Document d = null;// 文档对象

        try {
            db = dbf.newDocumentBuilder();// 从xml中获取xml文档实例
            d = db.parse(file);// 解析文档
            NodeList nl = d.getElementsByTagName("class");// 获取标签集合
            for (int i = 0; i < nl.getLength(); i++) {// 遍历，取值范围不大于集合的长度

                NodeList nl1 = d.getElementsByTagName("name");// 获取节点名集合
                Node n1 = nl1.item(i);
                String str1 = n1.getNodeName();// 获取标签信息
                LOG.info("标签信息:" + str1);
                LOG.info(d.getElementsByTagName("name"));// 输出地址值
                LOG.info(d.getElementsByTagName("name").item(i));// 节点名，值为null
                LOG.info(d.getElementsByTagName("name").item(i).getFirstChild());// 输出文本#text和姓名
                LOG.info(d.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());// 从文本#text和姓名中提取姓名
                LOG.info(d.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());// 输出年龄
            }
        } catch (ParserConfigurationException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (SAXException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
    }
}
