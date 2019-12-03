package cn.zjut.bean;

import java.io.Serializable;

/**
 * 学生参加的社团实体类
 */
public class StuClub implements Serializable {
    private String stu_id;
    private String club_id;

    public StuClub() {
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }
}
