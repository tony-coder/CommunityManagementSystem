package cn.zjut.bean;

import java.io.Serializable;

/**
 * 学生实体类
 */
public class Student implements Serializable {
    private String id;          //学号
    private String name;        //姓名
    private String sex;         //性别
    private String password;    //密码

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
