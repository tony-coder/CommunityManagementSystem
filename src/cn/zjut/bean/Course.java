package cn.zjut.bean;

import java.io.Serializable;

/**
 * 课程实体类
 */
public class Course implements Serializable {
    private String id;      //课程号
    private String name;    //课程名
    private String term;    //学期
    private String teacher; //授课教师

    public Course() {
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
