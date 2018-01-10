/**
 * Project Name:DT59BlueManTeam
 * File Name:qaz.java
 * Package Name:m01.lvwei.homework180110
 * Date:2018年1月10日下午8:13:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180110;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

        // Auto-generated method stub
        int dun = 888;
        // 端口
        OutputStream ou = null;
        ServerSocket serversocket = null;
        Socket socket = null;
        // ByteArrayOutputStream lvs = new ByteArrayOutputStream();
        FileWriter filewrtier;
        // 文本
        try {
            serversocket = new ServerSocket(dun);
            // 接受端口
            socket = serversocket.accept();
            InputStream is = socket.getInputStream();
            // 接受输出的HelloWorld
            filewrtier = new FileWriter("E:\\Java\\workspace\\workspace1\\src\\Text\\copy.txt");
            int b = -1;
            while ((b = is.read()) != -1) {
                filewrtier.write(b & 0xFF);
            }
            filewrtier.close();
            // byte[] byt = lvs.toByteArray();
            // String st = new String(byt);

        } catch (IOException e) {

        }

    }
}
