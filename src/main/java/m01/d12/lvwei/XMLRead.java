/**
 * Project Name:DT59BlueManTeam
 * File Name:qaz.java
 * Package Name:m01.lvwei.homework20180112
 * Date:2018年1月12日下午4:26:46
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180112;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 上午11:58:36 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class XMLRead {

    public static void main(String[] args) {
        long lasting = System.currentTimeMillis();
        NodeList childList = null;
        Node node = null;
        Node node1 = null;
        String no;
        try {
            File f = new File("E:\\Java\\workspace\\workspace1\\src\\lession180112\\NewFile.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            /* 获取 DocumentBuilderFactory 的新实例。 */
            DocumentBuilder builder = factory.newDocumentBuilder();
            /* 使用当前配置的参数创建一个新的 DocumentBuilder 实例。 */
            org.w3c.dom.Document doc = builder.parse(f);
            /* 将给定文件的内容解析为一个 XML 文档，并且返回一个新的 DOM Document 对象。 */
            org.w3c.dom.NodeList nl = doc.getElementsByTagName("employee");
            /* 按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList。 */
            System.out.println("学校：" + doc.getElementsByTagName("empoyees").item(0).getFirstChild().getNodeValue());
            for (int i = 0; i < nl.getLength(); i++) {
                childList = doc.getElementsByTagName("name");
                /* 按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList。 */
                node = childList.item(i);
                /* 返回集合中的第 index 个项。如果 index 大于或等于此列表中的节点数，则返回 null。 */
                node1 = node.getFirstChild();
                /* 此节点的第一个子节点。 */
                no = node1.getNodeValue();
                /* 此节点的值 */
                System.out.print("班级：" + doc.getElementsByTagName("Class").item(i).getFirstChild().getNodeValue()
                        + '\t');
                System.out.print("姓名：" + no + '\t');
                System.out.println("年龄：" + doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
            }
        } catch (DOMException e) {

            // Auto-generated catch block
            e.printStackTrace();

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
        System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + " 毫秒");
    }
}
