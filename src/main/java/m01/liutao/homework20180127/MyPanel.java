/**
 * Project Name:study
 * File Name:MyPanel.java
 * Package Name:hight
 * Date:2018年1月27日下午9:40:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liutao.homework20180127;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午9:40:39 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class MyPanel extends JPanel implements KeyListener,Runnable{
    
    MyTank mt=null;
    public MyPanel() {
        mt=new MyTank(40,50);
    }
    

    @Override
    public void paint(Graphics g) {       
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        drawTank(mt.getX(),mt.getY(),0,mt.getDirect(),g);
        for(int i=0;i<mt.vc.size();i++) {
            Shot st= mt.vc.get(i);
            if(st.islive==true&&mt.vc!=null) {
                g.draw3DRect(st.getX(), st.getY(), 3, 3, false);
            }
            if(st.islive==false) {
                mt.vc.remove(st);
            }
        }
    }
    public void drawTank(int x, int y,int type,int direct ,Graphics g) {
        switch(type) {
        case 0:
            g.setColor(Color.BLUE);
            break;
        case 1:
            g.setColor(Color.ORANGE);
            break;
        
        }
        switch(direct) {
        case 1://up
            g.fill3DRect(x, y, 30, 60, false);
            g.fill3DRect(x+30, y+10, 40, 40, false);
            g.fill3DRect(x+70, y, 30, 60, false);
            g.fillOval(x+35, y+20, 30,20);
            g.drawLine(x+50, y+20, x+50, y-5);            
            break;
        case 2://right
            g.fill3DRect(x, y, 60, 30, false);
            g.fill3DRect(x+10, y+30, 40, 40, false);
            g.fill3DRect(x, y+70, 60, 30, false);
            g.fillOval(x+20, y+35, 20,30);
            g.drawLine(x+40, y+50, x+75, y+50);  
            break;
        case 3://down
            g.fill3DRect(x, y, 30, 60, false);
            g.fill3DRect(x+30, y+10, 40, 40, false);
            g.fill3DRect(x+70, y,30, 60, false);
            g.fillOval(x+35, y+20,30,20);
            g.drawLine(x+50, y+40, x+50, y+65); 
            break;
        case 4://left
            g.fill3DRect(x, y, 60, 30, false);
            g.fill3DRect(x+10, y+30, 40, 40, false);
            g.fill3DRect(x, y+70, 60, 30, false);
            g.fillOval(x+20, y+35, 20,30);
            g.drawLine(x+20, y+50, x-5, y+50);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        //  Auto-generated method stub
        
    }


    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            mt.setDirect(1);
            moveup();
            
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            mt.setDirect(2);
            moveright();
            
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
            mt.setDirect(3);
            movedown() ;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            mt.setDirect(4);
            moveleft();
            
        }if(e.getKeyCode()==KeyEvent.VK_G) {
            if(mt.vc.size()<5) {
                mt.Fire();
            }
        }
        this.repaint();
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
        
        //  Auto-generated method stub
        
    }
    public void moveup() {
        int speed=mt.getSpeed();
        int y=mt.getY()-speed;
        if(y<0) {
            y=0;
        }
        mt.setY(y);
        System.out.println("up值"+y);
        
    }
public void moveright() {
    int  speed =mt.getSpeed();
    int x=mt.getX()+speed;
    if(x>720) {
        x=720;
    }
    mt.setX(x);
    System.out.println("right值"+x);
    }
public void movedown() {
    int speed=mt.getSpeed();
    int y=mt.getY()+speed;
    if(y>520) {
        y=510;
    }
    mt.setY(y);
    System.out.println("down值"+y);
    

    
}
public void moveleft() {
    int  speed =mt.getSpeed();
    int x=mt.getX()-speed;
    if(x<0) {
        x=0;
    }
    mt.setX(x);
    System.out.println("left值"+x);
    }


@Override
public void run() {
    while(true) {
        try {
            Thread.sleep(50);
            this.repaint();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
    
}




