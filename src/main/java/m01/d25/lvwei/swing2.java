/**
 * Project Name:workspace1
 * File Name:swing2.java
 * Package Name:lession180125
 * Date:2018��1��25������2:18:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.lvwei;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018��1��25�� ����2:18:47 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class swing2 extends JFrame {

    public swing2() {
        this.setBounds(300, 300, 400, 300);
        this.setTitle("̹�˴�ս");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        jpanl1 jpan = new jpanl1();
        this.addKeyListener(jpan);
        this.add(jpan);

        // JButton jb1, jb2;
        //
        // jb1 = new JButton("red");// ���ð�������
        // jb2 = new JButton("blue");
        // this.add(jb1, BorderLayout.NORTH);// ��ť�������ϣ�����
        // this.add(jb2, BorderLayout.SOUTH);// �������£��ϣ�

    }

    public static void main(String[] args) {
        swing2 sw = new swing2();
    }
}
