/**
 * Project Name:workspace1
 * File Name:FileRead.java
 * Package Name:lession180124
 * Date:2018��1��24������6:58:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.lvwei.homework20180124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Description: <br/>
 * Date: 2018��1��24�� ����6:58:36 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class FileRead {

    public static void main(String[] args) {

        // Auto-generated method stub

        Reader read = null;
        BufferedReader br = null;
        Writer writer = null;
        BufferedWriter bw = null;
        try {

            read = new FileReader("E:\\Java\\java.txt");
            br = new BufferedReader(read);
            writer = new FileWriter("E:\\Java\\java1.txt");
            bw = new BufferedWriter(writer);
            String st = br.readLine();
            while (st != null) {
                bw.write(st + "\r\n");
                st = br.readLine();
            }
            System.out.println("��д���");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                writer.close();
                br.close();
                read.close();

            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
    }
}
