/**
 * Project Name:DT59BlueManTeam
 * File Name:azq.java
 * Package Name:m01.lvwei.homework180110
 * Date:2018年1月10日下午8:12:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.lvwei;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午12:11:14 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class IPDemo {

    public static void main(String[] args) {
        System.out.println("开始上传");
        int dun = 888;
        // 输入端口
        String host = "lvwei-PC";
        // 本机名
        Socket socket = null;
        OutputStream ou = null;

        FileInputStream fr;
        ByteArrayOutputStream sb = new ByteArrayOutputStream();/* 创建字节数组 */

        try {
            InetAddress i = InetAddress.getByName(host);
            // 通过本机名转出本地ip
            socket = new Socket(i, dun);
            // 输出ip+端口
            ou = socket.getOutputStream();
            // 返回输出写入后的流
            // fr = new
            // FileReader("E:\\Java\\教学视频\\黑马程序员\\黑马程序员_毕向东_Java基础视频教程第01天-01-基本常识.avi");/*传视频*/
            fr = new FileInputStream("E:\\Java\\workspace\\workspace1\\src\\lession180107\\deom.txt");/* 传文档 */
            // fr = new FileInputStream("F:\\PICTURE\\辩论赛.jpg");/* 传图片 */
            // 从文件地址获得输入字符流
            int i1 = -1;
            while ((i1 = fr.read()) != -1) {
                // sb.write(i1 & 0xff);
                sb.write(i1);

            }
            byte[] st1 = sb.toByteArray();
            ou.write(st1);
            // 写入字节流
            ou.flush();
            // 刷新
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ou != null) {
                try {
                    ou.close();
                } catch (IOException e) {

                    e.printStackTrace();

                }
            }
        }

    }
}
