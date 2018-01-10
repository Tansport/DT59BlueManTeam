/**
 * Project Name:DT59BlueManTeam
 * File Name:SocketDemo1.java
 * Package Name:m01.liutao.homework20180110
 * Date:2018年1月10日下午6:46:17
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liutao.homework20180110;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:46:17 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class SocketDemo1 {// 不太会做，不知道到底用什么构造方法，对文件传送的过程不太懂
    @Test
    public void Demo1() {
        File fil = new File("C:\\Users\\Public\\Pictures\\t.jpg");// 实例发送文件的路径对象
        int port = 9999;// 接口号
        String Add = "DESKTOP-TAO";// PC电脑默认名

        Socket soc = null;// socket打开
        OutputStream os = null;// 输出流打开
        FileInputStream fis = null;// 文件输入流打开
        try {
            InetAddress addrees = InetAddress.getByName(Add);// 获取电脑IP地址
            soc = new Socket(addrees, port);// 实例化socket
            os = soc.getOutputStream();// 获取输出流
            fis = new FileInputStream(fil);// 实例化文件存放路径
            byte[] b = new byte[1024];// 定义数组接收文件数据
            int len;// 定义长度
            while ((len = fis.read(b)) != -1) {// 读取文件，当文件长度不等于-1，循环
                os.write(b, 0, len);// 从数组中写入文件
                os.flush();// 推送刷新
            }
        } catch (IOException e) {// 抓住异常

            e.printStackTrace();

        } finally {
            if (os != null) {// 输出流关闭
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            if (fis != null) {// 文件输入流关闭
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

            if (soc != null) {// socket关闭
                try {
                    soc.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }

    }
}
