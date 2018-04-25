/**
 * Project Name:Demo_dt59jsp_ajax02
 * File Name:Person.java
 * Package Name:com.dt59.entity
 * Date:2018年4月25日下午3:19:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月25日 下午3:19:08 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class Person {
    private String name;
    private int age;
    private char sex;
    private String zhiye;
    private String zhuzhi;
    private String dianh;
    
    public Person(){}
    
    public Person(String name,int age,char sex,String zhiye,String zhuzhi,String dianh){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.zhiye=zhiye;
        this.zhuzhi=zhuzhi;
        this.dianh=dianh;
        
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public String getZhiye() {
        return zhiye;
    }
    public void setZhiye(String zhiye) {
        this.zhiye = zhiye;
    }
    public String getZhuzhi() {
        return zhuzhi;
    }
    public void setZhuzhi(String zhuzhi) {
        this.zhuzhi = zhuzhi;
    }
    public String getDianh() {
        return dianh;
    }
    public void setDianh(String dianh) {
        this.dianh = dianh;
    }
    
}

