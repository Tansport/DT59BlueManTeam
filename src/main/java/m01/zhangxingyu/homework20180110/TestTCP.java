/**
 * Project Name:DT59BlueManTeam
 * File Name:TestTCP.java
 * Package Name:m01.zhangxinyu.homewrok20180110
 * Date:2018年1月10日上午11:10:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhangxingyu.homework20180110;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年1月10日 上午11:10:12 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class TestTCP {

    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

            os = socket.getOutputStream();

            os.write("我是客户端".getBytes());

            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    // 服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        try {
            ss = new ServerSocket(9090);

            s = ss.accept();

            is = s.getInputStream();

            byte[] b = new byte[20];

            int len;

            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
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
