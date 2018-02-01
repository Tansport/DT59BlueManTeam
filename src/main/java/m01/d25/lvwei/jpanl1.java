/**
 * Project Name:workspace1
 * File Name:jpanl1.java
 * Package Name:lession180125
 * Date:2018��1��25������2:23:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.lvwei;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description: <br/>
 * Date: 2018��1��25�� ����2:23:08 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
@SuppressWarnings("serial")
public class jpanl1 extends JPanel implements KeyListener {
    int x = 0, y = 0, a;

    public void paint(Graphics g) {// ���Ʒ��� g:����
        this.setBackground(Color.black);
        super.paint(g);
        switch (a) {
        case (1):
            g.setColor(Color.blue);// ������ɫ
            g.drawRect(x, y, 30, 10);
            g.drawRect(x, y + 25, 30, 10);
            g.setColor(Color.yellow);// ������ɫ
            g.fillOval(x + 7, y + 7, 20, 20);
            g.setColor(Color.green);// ������ɫ
            g.drawLine(x + 23, y + 17, x + 45, y + 17);
            break;
        case (2):
            g.setColor(Color.blue);// ������ɫ
            g.drawRect(x, y, 10, 30);
            g.drawRect(x + 25, y, 10, 30);
            g.setColor(Color.yellow);// ������ɫ
            g.fillOval(x + 7, y + 4, 20, 20);
            g.setColor(Color.green);// ������ɫ
            g.drawLine(x + 17, y + 10, x + 17, y - 15);
            break;
        case (3):
            g.setColor(Color.blue);// ������ɫ
            g.drawRect(x, y, 10, 30);
            g.drawRect(x + 25, y, 10, 30);
            g.setColor(Color.yellow);// ������ɫ
            g.fillOval(x + 7, y + 7, 20, 20);
            g.setColor(Color.green);// ������ɫ
            g.drawLine(x + 17, y + 20, x + 17, y + 43);
            break;
        case (4):
            g.setColor(Color.blue);// ������ɫ
            g.drawRect(x, y, 30, 10);
            g.drawRect(x, y + 25, 30, 10);
            g.setColor(Color.yellow);// ������ɫ
            g.fillOval(x + 4, y + 7, 20, 20);
            g.setColor(Color.green);// ������ɫ
            g.drawLine(x - 14, y + 17, x + 10, y + 17);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            a = 4;
            this.x = x - 5;
            if (x <= 0) {
                this.x = 0;
            }
            System.out.println("����x=" + x);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            a = 2;
            this.y = y - 5;
            if (y <= 0) {
                this.y = 0;
            }
            System.out.println("����y=" + y);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            a = 3;
            this.y = y + 5;
            if (y >= 300) {
                this.y = 300;
            }
            System.out.println("����y=" + y);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            a = 1;
            this.x = x + 5;
            if (x >= 400 - 45) {
                this.x = 400 - 45;
            }
            System.out.println("����x=" + x);
        }
        this.repaint();
        // Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {

        // Auto-generated method stub

    }

}
