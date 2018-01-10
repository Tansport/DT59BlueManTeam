/**
 * Project Name:DT59BlueManTeam
 * File Name:azq.java
 * Package Name:m01.lvwei.homework180110
 * Date:2018年1月10日下午8:12:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180110;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
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
        int dun = 888;
        // 输入端口
        String host = "lvwei-PC";
        // 本机名
        Socket socket = null;
        OutputStream ou = null;
        FileReader fr = null;
        ByteArrayOutputStream sb = new ByteArrayOutputStream();
        try {
            InetAddress i = InetAddress.getByName(host);
            // 通过本机名转出本地ip
            socket = new Socket(i, dun);
            // 输出ip+端口
            ou = socket.getOutputStream();
            // 输出
            fr = new FileReader("E:\\Java\\workspace\\workspace1\\src\\lession180107\\deom.txt");
            int i1 = -1;
            while ((i1 = fr.read()) != -1) {
                sb.write(i1 & 0xff);
            }
            byte[] st1 = sb.toByteArray();
            ou.write(st1);
            // 输出HelloWorld
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
                    fr.close();
                } catch (IOException e) {

                    e.printStackTrace();

                }
            }
        }

    }
}
