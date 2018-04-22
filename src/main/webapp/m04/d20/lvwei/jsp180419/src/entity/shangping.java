/**
 * Project Name:jsp180419
 * File Name:shangping.java
 * Package Name:entity
 * Date:2018年4月19日下午2:09:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午2:09:25 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class shangping {
    private int spid;

    private String spname;

    private float spprice;

    private String spdesc;

    private int num = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public float getSpprice() {
        return spprice;
    }

    public void setSpprice(float spprice) {
        this.spprice = spprice;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

}
