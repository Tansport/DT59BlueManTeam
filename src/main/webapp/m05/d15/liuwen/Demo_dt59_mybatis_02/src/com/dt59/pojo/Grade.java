/**
 * Project Name:Demo_dt59_mybatis_02
 * File Name:Grade.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月15日下午5:00:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: <br/>
 * Date: 2018年5月15日 下午5:00:57 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Grade {
    private int sgid;

    private String gname;

    private Set<Stu> stuu = new HashSet<Stu>();// 一方装多方,一个年级里面多个人

    public int getSgid() {
        return sgid;
    }

    public void setSgid(int sgid) {
        this.sgid = sgid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Set<Stu> getStuu() {
        return stuu;
    }

    public void setStuu(Set<Stu> stuu) {
        this.stuu = stuu;
    }

}
