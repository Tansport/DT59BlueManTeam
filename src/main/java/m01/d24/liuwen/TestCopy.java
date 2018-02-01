/**
 * Project Name:DT59BlueManTeam
 * File Name:TestCopy.java
 * Package Name:m01.liuwen.homework20180124
 * Date:2018年1月24日下午6:39:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liuwen.homework20180124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description:   <br/>
 * Date:     2018年1月24日 下午6:39:21 <br/>
 * @author   WEN LIU
 * @version
 * @see
 */
/**
 * 使用BufferedReader来实现文件的复制
 */
public class TestCopy {

    public static void main(String[] args) {
        File file1 = null;
        FileReader fr = null;
        BufferedReader br = null;
        File file2 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            file1 = new File("D:/1.txt");
            fr = new FileReader(file1);
            br = new BufferedReader(fr);

            file2 = new File("D:/2222.txt");
            fw = new FileWriter(file2);
            bw = new BufferedWriter(fw);

            String str = br.readLine();
            while (str != null) {
                bw.write(str + "/t/n");
                str = br.readLine();// 能实现文本的复制，但是复制出来的都是乱码
            }
            System.out.println("复制已经完成");
        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                bw.close();
                fw.close();
                br.close();
                fr.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
