/**
 * Project Name:homework
 * File Name:HelloServerSock.java
 * Package Name:test.Z2018_1_10
 * Date:2018年1月10日下午7:13:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhengheyang.homework20180110;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:13:23 <br/>
 * 
 * @author Zhengheyang
 * @version
 * @see
 */
public class HelloServer {
    private final static Logger LOG = LoggerFactory.getLogger(HelloServer.class);

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        LOG.info("等待客户端连接......");
        Socket client = server.accept();
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Hello World !");
        out.close();
        client.close();
        server.close();
    }
}
