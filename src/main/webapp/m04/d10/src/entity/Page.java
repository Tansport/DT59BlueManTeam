/**
 * Project Name:workJSP
 * File Name:Page.java
 * Package Name:entity
 * Date:2018年4月10日上午9:52:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午9:52:18 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Page {

    private int currentpage;

    private int pagesize = 3;

    private int sumsize;

    private int lastpage;

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
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
