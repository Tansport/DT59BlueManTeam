/**
 * Project Name:Demo_dt59_infomation
 * File Name:Person.java
 * Package Name:com.dt59.entity
 * Date:2018年4月25日下午7:55:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月25日 下午7:55:01 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Person {
    private String name;

    private int age;

    private String sex;

    private String jop;

    private String address;

    private String phone;

    public Person() {

    }

    public Person(String name, int age, String sex, String jop, String address, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.jop = jop;
        this.address = address;
        this.phone = phone;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
