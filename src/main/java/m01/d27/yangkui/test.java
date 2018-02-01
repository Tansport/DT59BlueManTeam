/**
 * Project Name:Test
 * File Name:test.java
 * Package Name:Dmeo04
 * Date:2018年1月27日下午3:01:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yangkui;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午3:01:11 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class test extends JFrame {

    public static void main(String[] args) {
        test tt = new test();

    }

    public test() {
        MyPanel mp = new MyPanel();
        this.addKeyListener(mp);
        Thread th = new Thread(mp);
        th.start();
        this.add(mp);
        this.setTitle("java窗体");
        this.setBounds(200, 200, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
