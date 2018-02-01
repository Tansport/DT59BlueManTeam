/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:hight
 * Date:2018年1月27日下午9:40:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.liutao;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午9:40:49 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test extends JFrame {
    public static void main(String[] args) {
        Test t = new Test();
    }

    public Test() {
        MyPanel mp = new MyPanel();
        this.addKeyListener(mp);
        Thread th = new Thread(mp);
        th.start();
        this.add(mp);// 第一，这个语句必须在线程之后
        this.setTitle("坦克大战");
        this.setBounds(200, 200, 800, 610);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
