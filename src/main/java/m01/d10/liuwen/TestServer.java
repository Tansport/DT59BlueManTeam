/**
 * Project Name:DT59BlueManTeam
 * File Name:TestServer.java
 * Package Name:m01.liuwen.homework20180110
 * Date:2018年1月10日下午6:40:28
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.liuwen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:40:28 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class TestServer {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\2.jpg"));
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
                fos.flush();
            }
            os = socket.getOutputStream();
            os.write("我是服务端，我收到了你的消息，谢谢！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
