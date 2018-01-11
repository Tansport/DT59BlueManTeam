/**
 * Project Name:homework
 * File Name:HelloClient.java
 * Package Name:test.Z2018_1_10
 * Date:2018年1月10日下午7:22:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package test.Z2018_1_10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:22:13 <br/>
 * 
 * @author Zhengheyang
 * @version
 * @see
 */
public class HelloClient {
    private final static Logger LOG = LoggerFactory.getLogger(HelloClient.class);

    public static void main(String[] args) throws Exception {
        InputStream fileObject = new FileInputStream("D:\\Git_coid\\README.md");
        Socket client = new Socket("localhost", 9999);
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        if (scan.hasNext()) {
            LOG.info("回应数据!");
        }
        scan.close();
        client.close();
    }
}
