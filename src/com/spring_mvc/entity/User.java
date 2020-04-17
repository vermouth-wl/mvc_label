package com.spring_mvc.entity;


import java.util.Date;

public class User {
    private String name;
    private String sex;
    private Integer age;
    private String password;
    private String introduce;
    private Integer deptid;
    private Date birthday;

    // 构造方法
    public User(){}



    public User(String name, String sex, Integer age, String password, String introduce, Integer deptid, Date birthday){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.introduce = introduce;
        this.deptid = deptid;
        this.birthday = birthday;
    }

    // getter()和setter()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
