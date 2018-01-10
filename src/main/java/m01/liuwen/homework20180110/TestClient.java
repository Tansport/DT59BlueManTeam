/**
 * Project Name:DT59BlueManTeam
 * File Name:TestClient.java
 * Package Name:m01.liuwen.homework20180110
 * Date:2018年1月10日下午6:33:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liuwen.homework20180110;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:33:41 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class TestClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = socket.getOutputStream();
            File file = new File("C:\\Users\\admin\\Desktop\\1.jpg");
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
                os.flush();
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            byte[] b1 = new byte[1024];
            int len1;
            while ((len1 = is.read(b1)) != -1) {
                String str = new String(b1, 0, len1);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }

            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }

            }
        }

    }
}
