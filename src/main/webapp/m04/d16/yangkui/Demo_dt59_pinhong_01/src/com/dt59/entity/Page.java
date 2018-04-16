/**
 * Project Name:Demo_dt59_jsp_01
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:2018年4月10日上午9:55:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午9:55:05 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class Page {
    private int currentpage;

    private int pagesize=3;

    private int sumsize;

    private int lastpage;

    public int getCurrentpage() {
        
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if(currentpage<=0){
            this.currentpage=1;
        }else{
            if(currentpage>this.lastpage){
                this.currentpage=this.lastpage;
            }else{
                this.currentpage = currentpage;
            }
        }
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSumsize() {
        return sumsize;
    }

    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

}
