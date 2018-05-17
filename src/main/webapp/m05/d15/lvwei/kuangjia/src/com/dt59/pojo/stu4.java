/**
 * Project Name:kuangjia
 * File Name:stu4.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月17日上午9:24:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: <br/>
 * Date: 2018年5月17日 上午9:24:31 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class stu4 {
    private int id;

    private String aname;

    private Set<Stu> stuu = new HashSet<Stu>();

    public Set<Stu> getStuu() {
        return stuu;
    }

    public void setStuu(Set<Stu> stuu) {
        this.stuu = stuu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

}
