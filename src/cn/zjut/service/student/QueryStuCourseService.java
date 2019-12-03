package cn.zjut.service.student;

import cn.zjut.bean.StuCourse;
import cn.zjut.dao.StudentDao;

import java.util.ArrayList;

public class QueryStuCourseService {
    private static StudentDao studentDao = new StudentDao();

    public static ArrayList<StuCourse> getAllStuCourse() {
        return studentDao.getAllStuCourses();
    }

    public static ArrayList<StuCourse> queryStuCourse(String term, String stuName) {
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        stuCourses = studentDao.queryStuCourse(term, stuName);
        if (stuCourses.size() == 0) {
            return null;
        }
        return stuCourses;
    }

    public static ArrayList<StuCourse> queryStuCourseByTerm(String term) {
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        stuCourses = studentDao.queryStuCourseByTerm(term);
        if (stuCourses.size() == 0) {
            return null;
        }
        return stuCourses;
    }

    public static ArrayList<StuCourse> queryStuCourseByName(String name) {
        ArrayList<StuCourse> stuCourses = new ArrayList<>();
        stuCourses = studentDao.queryStuCourseByName(name);
        if (stuCourses.size() == 0) {
            return null;
        }
        return stuCourses;
    }

    public static ArrayList<StuCourse> queryAllSelectedCourseInClub(String stuId, String clubId, String term) {
        return studentDao.getAllSelectedCourseInClub(stuId, clubId, term);
    }

    public static ArrayList<StuCourse> queryUnselectedCourseInClub(String stuId, String clubId, String term) {
        return studentDao.getUnselectedCourseInClub(stuId, clubId, term);
    }

}
