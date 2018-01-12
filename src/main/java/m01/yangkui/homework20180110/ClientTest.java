/**
 * Project Name:DT59BlueManTeam
 * File Name:SocketTest.java
 * Package Name:m01.yangkui.homework20180110
 * Date:2018年1月10日下午6:56:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.yangkui.homework20180110;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.print.attribute.standard.Severity;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:56:12 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class ClientTest {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        // InputStream is=null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("USER-4ICR6FMTU6"), 13579);
            os = socket.getOutputStream();
            // is=socket.getInputStream();
            File file = new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
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
        }

    }

}
