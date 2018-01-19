/**
 * Project Name:DT59BlueManTeam
 * File Name:TCPTest.java
 * Package Name:m01.zhangxinyu.homewrok20180110
 * Date:2018年1月10日下午6:45:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhangxinyu.homewrok20180110;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.stream.FileImageInputStream;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:45:13 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see Socket编程，编写服务端及客户端代码，实现：客户端发送本地文件内容，服务端接受文件内容，并保存。
 */
public class TCPTest {

    // 客户端
    @Test
    public void client() {
        Socket socker = null;
        OutputStream os = null;
        FileImageInputStream fos = null;
        InputStream is = null;
        try {
            socker = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

            os = socker.getOutputStream();
            File file = new File("C:\\Users\\57745\\Desktop\\1.jpg");
            fos = new FileImageInputStream(file);
            byte[] b = new byte[1024];
            int len;
            while ((len = fos.read()) != -1) {
                os.write(b, 0, len);
                os.flush();
            }
            socker.shutdownOutput();
            is = socker.getInputStream();
            byte[] b1 = new byte[1024];
            int len1;
            while ((len1 = is.read(b1)) != -1) {
                String str = new String(b1, 0, len1);
                System.out.println(str);
            }
        } catch (UnknownHostException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (FileNotFoundException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
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
            if (fos != null) {
                try {
                    fos.close();
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
            if (socker != null) {
                try {
                    socker.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
        }

    }
}
