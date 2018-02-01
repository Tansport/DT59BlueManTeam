/**
 * Project Name:DT59BlueManTeam
 * File Name:Demo.java
 * Package Name:m01.zhangxinyu.homewrok20180110
 * Date:2018年1月10日上午9:53:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.zhangxingyu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年1月10日 上午9:53:04 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Demo {
    //
    // // 客户端
    // @Test
    // public void client() {
    // Socket socket = null;
    // OutputStream os = null;
    // try {
    // socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
    //
    // os = socket.getOutputStream();
    //
    // os.write("我是客户端".getBytes());
    // } catch (IOException e) {
    // e.printStackTrace();
    //
    // } finally {
    // if (os != null) {
    // try {
    // os.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    //
    // }
    //
    // }
    // if (socket != null) {
    // try {
    // socket.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    //
    // }
    //
    // }
    // }
    //
    // }

    // 服务端
    @Test
    public void Server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(9090);

            s = ss.accept();

            is = s.getInputStream();

            fos = new FileOutputStream(new File("C:\\Users\\57745\\Desktop\\2.jpg"));
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
                fos.flush();
            }
            OutputStream os = s.getOutputStream();
            os.write("图片接受成功".getBytes());
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
            if (s != null) {
                try {
                    s.close();
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
