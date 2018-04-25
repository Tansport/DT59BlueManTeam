package com.dt59.entity;

public class Person {
    private String name;

    private int age;

    private String sex;

    private String job;

    private String address;

    private String phonenumber;

    public Person() {
        super();
    }

    public Person(String name, int age, String sex, String job, String address, String phonenumber) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.job = job;
        this.address = address;
        this.phonenumber = phonenumber;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
