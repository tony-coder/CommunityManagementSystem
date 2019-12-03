package cn.zjut.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 社团实体类
 */
public class Club implements Serializable {
    private String id;          //社团号
    private String name;        //社团名
    private String description; //社团简介

    public Club() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) &&
                Objects.equals(name, club.name) &&
                Objects.equals(description, club.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}