/**
 * Project Name:Test
 * File Name:MyTanKe.java
 * Package Name:Dmeo04
 * Date:2018年1月27日下午3:08:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.yangkui;

import java.util.Vector;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午3:08:02 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class MyTanKe extends TanKe {
    private int direct;

    private int speed = 3;

    private Shot shot = null;

    Vector<Shot> vect = new Vector<Shot>();

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Vector<Shot> getVete() {
        return vect;
    }

    public void setVete(Vector<Shot> vete) {
        this.vect = vete;
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

    public MyTanKe() {
        super();
    }

    public MyTanKe(int x, int y) {
        super(x, y);
    }

    public void tkFire() {
        if (this.direct == 0) {
            // 向上
            shot = new Shot(this.getX() + 34, this.getY() - 10, this.direct);
            vect.add(shot);

        } else if (this.direct == 1) {
            // 向右
            shot = new Shot(this.getX() + 60, this.getY() + 34, this.direct);
            vect.add(shot);
        } else if (this.direct == 2) {// 向下
            shot = new Shot(this.getX() + 34, this.getY() + 60, this.direct);
            vect.add(shot);

        } else if (this.direct == 3) {
            // 向左
            shot = new Shot(this.getX() - 10, this.getY() + 34, this.direct);
            vect.add(shot);
        }

        System.out.println("子弹坐标：x=" + shot.getX() + " y=" + shot.getY());
        Thread th = new Thread(shot);
        th.start();
    }
}
