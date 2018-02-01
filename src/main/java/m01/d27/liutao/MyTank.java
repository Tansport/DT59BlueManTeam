/**
 * Project Name:study
 * File Name:MyTank.java
 * Package Name:hight
 * Date:2018年1月27日下午9:38:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.liutao;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午9:38:41 <br/>
 * @author   liutao
 * @version
 * @see
 */

import java.util.Vector;

public class MyTank extends Tank {
    private int direct = 1;

    private int speed = 4;

    private Shot shot = null;

    Vector<Shot> vc = new Vector<Shot>();

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public Vector<Shot> getVc() {
        return vc;
    }

    public void setVc(Vector<Shot> vc) {
        this.vc = vc;
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

    public MyTank() {
        super();
    }

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void Fire() {
        if (this.direct == 1) {
            shot = new Shot(this.getX() + 50, this.getY() - 5, direct);
            vc.add(shot);
        } else if (this.direct == 2) {
            shot = new Shot(this.getX() + 65, this.getY() + 50, direct);
            vc.add(shot);
        } else if (this.direct == 3) {
            shot = new Shot(this.getX() + 50, this.getY() + 65, direct);
            vc.add(shot);
        } else if (this.direct == 4) {
            shot = new Shot(this.getX() - 5, this.getY() + 50, direct);
            vc.add(shot);
        }
        System.out.println("子弹坐标" + shot.getX() + "\t" + shot.getY());
        Thread th = new Thread(shot);
        th.start();

    }

}
