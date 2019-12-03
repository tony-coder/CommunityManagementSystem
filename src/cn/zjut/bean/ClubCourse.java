package cn.zjut.bean;

import java.io.Serializable;

/**
 * 社团开设课程实体类
 */
public class ClubCourse extends Course implements Serializable {
    private String clubName;

    public ClubCourse() {
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
