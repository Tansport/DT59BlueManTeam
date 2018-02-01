/**
 * Project Name:DT59BlueManTeam
 * File Name:ServerTest.java
 * Package Name:m01.yangkui.homework20180110
 * Date:2018年1月10日下午7:39:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.yangkui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:39:43 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class ServerTest {
    public static void main(String[] args) {
        ServerSocket se = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            se = new ServerSocket(13579);
            socket = se.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\2.jpg"));
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
            }
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
            if (se != null) {
                try {
                    se.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
