package com.hxz.mybatis.entity;

import java.io.Serializable;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-02-28-21:05
 * @address 成都
 */
public class Emp implements Serializable {
    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Integer did;

    private Dept dept;

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getEid() {
        return eid;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Integer getDid() {
        return did;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }

    public Emp() {
    }

    public Emp(Integer eid, String empName, Integer age, String sex, String email, Integer did) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.did = did;
    }
}
