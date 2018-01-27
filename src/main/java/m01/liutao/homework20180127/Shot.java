/**
 * Project Name:study
 * File Name:Shot.java
 * Package Name:hight
 * Date:2018年1月27日下午11:18:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.liutao.homework20180127;
/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午11:18:56 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class Shot implements Runnable {
    int x;
    int y;
    int direct;
    int speed=5;
    boolean islive=true;
    public Shot() {
        
    }
    public Shot(int x,int y, int direct) {
        this.x=x;
        this.y=y;
        this.direct=direct;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDirect() {
        return direct;
    }
    public void setDirect(int direct) {
        this.direct = direct;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean isIslive() {
        return islive;
    }
    public void setIslive(boolean islive) {
        this.islive = islive;
    }
    @Override
    public void run() {
        while(true) {
            try {
                switch(this.direct) {
                case 1://up
                    this.y-=this.speed;
                    break;
                case 2://right
                    this.x+=this.speed;
                    break;
                case 3://down
                    this.y+=this.speed;                
                    break;
                case 4://left
                    this.x-=this.speed;
                    break;
                }
                Thread.sleep(40);
                
            } catch (Exception e) {
                e.printStackTrace();
            }if(this.x<0||this.x>740||this.y<0||this.y>510) {
                this.islive=false;
                break;
                
            }
        }
        
    }
   
    

}

