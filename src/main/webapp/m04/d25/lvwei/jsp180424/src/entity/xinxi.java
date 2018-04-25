/**
 * Project Name:jsp180424
 * File Name:xinxi.java
 * Package Name:entity
 * Date:2018年4月25日下午8:56:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月25日 下午8:56:58 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class xinxi {
    private String name;

    private int age;

    private char sex;

    private String zhiye;

    private String zhuzhi;

    private String phone;

    public xinxi() {
    }

    public xinxi(String name, int age, char sex, String zhiye, String zhuzhi, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.zhiye = zhiye;
        this.zhuzhi = zhuzhi;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
