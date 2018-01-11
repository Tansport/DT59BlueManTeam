/**
 * Project Name:DT59BlueManTeam
 * File Name:qaz.java
 * Package Name:m01.lvwei.homework180110
 * Date:2018年1月10日下午8:13:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180110;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午4:32:36 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class ServerSocketDemo {

    /**
     * Description: <br/>
     *
     * @author lvwei
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("开始接收");
        int dun = 888;
        // 端口
        ServerSocket serversocket = null;
        Socket socket = null;
        // ByteArrayOutputStream lvs = new ByteArrayOutputStream();
        // StringBuilder lvs1 = new StringBuilder();
        // File filewrtier;
        FileOutputStream filewrtier = null;
        // FileOutputStream fo = null;
        // 文本
        InputStream is = null;
        // 读取OutputStream的数据
        try {
            serversocket = new ServerSocket(dun);
            // 接受端口
            socket = serversocket.accept();
            is = socket.getInputStream();/* 接收该端口的数据 */
            // filewrtier = new
            // FileWriter("F:\\VIDEO\\明道\\明道MV\\黑马程序员_毕向东_Java基础视频教程第01天-01-基本常识.avi");/*
            // 接收视频 */
            filewrtier = new FileOutputStream("E:\\Java\\workspace\\workspace1\\src\\lession180107\\deom2.txt");
            // 接收文档字节流
            // filewrtier = new FileOutputStream("F:\\PICTURE\\辩论赛1.jpg");/*
            // 传图片*/
            byte by[] = new byte[1024];
            int b = -1;
            while ((b = is.read(by)) != -1) {
                // filewrtier.write(b & 0xFF);
                filewrtier.write(by, 0, b);
                filewrtier.flush();
                // if (b == '\n') {
                // continue;
                // }
                // lvs.write(b);

            }
            // lvs.flush();
            // byte[] by = lvs.toByteArray();
            // fo = new FileOutputStream(filewrtier);
            // fo.write(by);
            // fo.close();
            // lvs.close();
            // byte[] byt = lvs.toByteArray();
            // String st = new String(byt);

        } catch (IOException e) {

        } finally {
            if (filewrtier != null) {
                try {
                    filewrtier.close();
                    is.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
        }
    }
}
