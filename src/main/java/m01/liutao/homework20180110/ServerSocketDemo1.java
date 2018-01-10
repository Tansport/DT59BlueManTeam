/**
 * Project Name:DT59BlueManTeam
 * File Name:ServerSocketDemo1.java
 * Package Name:m01.liutao.homework20180110
 * Date:2018年1月10日下午7:26:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liutao.homework20180110;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:26:06 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class ServerSocketDemo1 {
    @Test
    public void Demo2() {
        int port = 9999;// 定义端口号
        File fil = new File("C:\\Users\\Public\\t1.jpg");// 定义服务端文件绝对路径
        Socket soc = null;// socket打开
        InputStream is = null;// 输入流打开
        FileOutputStream fos = null;// 文件输出流打开
        ServerSocket ss=null;
        try {
            ss = new ServerSocket(port);// 实例服务端接口
            soc = ss.accept();// 接口接收文件定义为socket型
            is = soc.getInputStream();// 输入流中获取文件
            fos = new FileOutputStream(fil);// 实例文件输出
            byte[] b = new byte[1024];// 定义一个数组接收文件
            int len;// 定义长度
            while ((len = (is.read(b))) != -1) {// 文件长度不等与-1执行循环
                fos.write(b, 0, len);// 循环写文件

            }
        } catch (IOException e) {// 抓异常

            e.printStackTrace();

        } finally {
            if (fos != null) {// 关闭文件输入流
                try {
                    fos.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            if (is != null) {// 关闭输入流
                try {
                    is.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
            if (soc != null) {// 关闭socket
                try {
                    soc.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();
                    

                }
            }
            if (ss != null) {// 关闭socket
                try {
                    ss.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();
        }
    }

}
    }
}
