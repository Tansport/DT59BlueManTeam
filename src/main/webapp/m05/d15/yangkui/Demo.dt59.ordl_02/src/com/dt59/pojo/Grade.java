/**
 * Project Name:Demo.dt59.ordl_02
 * File Name:grade.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月15日下午3:30:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:   <br/>
 * Date:     2018年5月15日 下午3:30:44 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class Grade {
    private int sgid;
    private String gname;
    private Set<Stu> stu=new HashSet<Stu>();
    
    public Set<Stu> getStu() {
        return stu;
    }
    public void setStu(Set<Stu> stu) {
        this.stu = stu;
    }
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
    
}

