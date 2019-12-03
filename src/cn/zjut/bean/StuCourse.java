package cn.zjut.bean;

import java.io.Serializable;

/**
 * 学生选的课程实体类
 */
public class StuCourse implements Serializable {
    private String stu_id;      //学号
    private String stu_name;    //姓名
    private String course_id;   //课程号
    private String course_name; //课程名
    private String term;        //学期
    private double score;       //学生成绩

    public StuCourse() {
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
