/**
 * Project Name:lession1
 * File Name:DemoFilerReader.java
 * Package Name:lession18
 * Date:2018年1月24日下午6:57:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.zhangxingyu.homework20180125;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午6:57:51 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class DemoFilerReader {
    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        FileWriter hw = null;
        try {
            fr = new FileReader("e:\\1.txt");
            br = new BufferedReader(fr);
            hw = new FileWriter("e:\\2.txt");
            bw = new BufferedWriter(hw);

            String str = br.readLine();
            while (str != null) {
                bw.write(str + "\r\n");
                str = br.readLine();
            }
            System.out.println("读写完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                hw.close();

                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}