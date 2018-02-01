/**
 * Project Name:Test
 * File Name:MyPanel.java
 * Package Name:Dmeo04
 * Date:2018年1月27日下午3:06:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yangkui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午3:06:00 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    MyTanKe mt = null;

    public MyPanel() {
        mt = new MyTanKe(40, 50);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 300);
        drawtanke(mt.getX(), mt.getY(), 1, mt.getDirect(), g);
        for (int i = 0; i < mt.vect.size(); i++) {
            Shot st = mt.vect.get(i);
            if (st.isLive() && mt.vect != null) {
                g.fill3DRect(st.getX(), st.getY(), 3, 3, false);
            }
            if (st.isLive() == false) {
                mt.vect.remove(st);
            }
        }
    }

    private void drawtanke(int x, int y, int type, int direct, Graphics g) {
        switch (type) {
        case 1:
            g.setColor(Color.red);
            break;
        case 2:
            g.setColor(Color.yellow);
            break;
        }
        switch (direct) {
        case 0:// 向上
               // 左边的矩形
               // g.fillRect(x, y, 20, 50);
            g.fill3DRect(x, y, 20, 50, false);
            // 中间的矩形
            g.fill3DRect(x + 20, y + 10, 30, 30, false);
            // 右边的矩形
            g.fill3DRect(x + 50, y, 20, 50, false);
            // 中间的炮台
            g.fillOval(x + 25, y + 15, 20, 20);
            // 中间的线
            g.drawLine(x + 35, y + 15, x + 35, y - 10);
            break;
        case 1:// 向右
               // 上边的矩形
            g.fill3DRect(x, y, 50, 20, false);
            // 中间的矩形
            g.fill3DRect(x + 10, y + 20, 30, 30, false);
            // 右边的矩形
            g.fill3DRect(x, y + 50, 50, 20, false);
            // 中间的炮台
            g.fillOval(x + 15, y + 25, 20, 20);
            // 中间的线
            g.drawLine(x + 35, y + 35, x + 60, y + 35);
            break;
        case 2:// 向下
               // 左边的矩形
               // g.fillRect(x, y, 20, 50);
            g.fill3DRect(x, y, 20, 50, false);
            // 中间的矩形
            g.fill3DRect(x + 20, y + 10, 30, 30, false);
            // 右边的矩形
            g.fill3DRect(x + 50, y, 20, 50, false);
            // 中间的炮台
            g.fillOval(x + 25, y + 15, 20, 20);
            // 中间的线
            g.drawLine(x + 35, y + 35, x + 35, y + 60);
            break;
        case 3:// 向左
               // 上边的矩形
            g.fill3DRect(x, y, 50, 20, false);
            // 中间的矩形
            g.fill3DRect(x + 10, y + 20, 30, 30, false);
            // 右边的矩形
            g.fill3DRect(x, y + 50, 50, 20, false);
            // 中间的炮台
            g.fillOval(x + 15, y + 25, 20, 20);
            // 中间的线
            g.drawLine(x + 15, y + 35, x - 10, y + 35);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // 向上
            mt.setDirect(0);
            // 移动
            moveup();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // 向右
            mt.setDirect(1);
            moveright();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // 向下
            mt.setDirect(2);
            movedown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // 向左
            mt.setDirect(3);
            moveleft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            if (mt.vect.size() < 5) {
                mt.tkFire();

            }
        }
        // 重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // Auto-generated method stub

    }

    public void moveup() {

        int speed = mt.getSpeed();// 先获取速度
        int y = mt.getY() - speed;// 运算
        if (y < 4) {
            y = 9;
        }
        mt.setY(y);
        System.out.println("当前y=" + y);
    }

    // 向右
    public void moveright() {

        int speed = mt.getSpeed();// 先获取速度
        int x = mt.getX() + speed;// 运算
        if (x > 330) {
            x = 325;
        }
        mt.setX(x);
        System.out.println("当前x=" + x);
    }

    // 向左
    public void moveleft() {

        int speed = mt.getSpeed();// 先获取速度
        int x = mt.getX() - speed;// 运算
        if (x < 2) {
            x = 7;
        }
        mt.setX(x);
        System.out.println("当前x=" + x);
    }

    public void movedown() {

        int speed = mt.getSpeed();// 先获取速度
        int y = mt.getY() + speed;// 运算
        if (y > 206) {
            y = 201;
        }
        mt.setY(y);
        System.out.println("当前y=" + y);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                this.repaint();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
