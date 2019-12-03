package cn.zjut.service.course;

import cn.zjut.bean.Club;
import cn.zjut.bean.ClubCourse;
import cn.zjut.dao.ClubDao;
import cn.zjut.dao.CourseDao;

import java.util.ArrayList;

public class QueryCourseService {
    private static CourseDao courseDao = new CourseDao();

    public static ArrayList<ClubCourse> queryAllCourse() {
        return courseDao.findCourseByNamefuzzy("");
    }

    public static ArrayList<ClubCourse> queryCourseByName(String name) {
        return courseDao.findCourseByNamefuzzy(name);
    }

    public static ArrayList<ClubCourse> queryCourseById(String id) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByID(id);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTeacher(String teacher) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByTeacher(teacher);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTerm(String term) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByTerm(term);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTermName(String term, String name) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByTermName(term, name);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTermId(String term, String id) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByTermId(term, id);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTermTeacher(String term, String teacher) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        courses = courseDao.getCourseByTermTeacher(term, teacher);
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByClubName(String clubName) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        ClubDao clubDao = new ClubDao();
        Club club = clubDao.getClubByName(clubName).get(0);
        courses = courseDao.getCourseByClub(club.getId());
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourseByTermClubName(String term, String clubName) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        ClubDao clubDao = new ClubDao();
        Club club = clubDao.getClubByName(clubName).get(0);
        courses = courseDao.getCourseByTermClub(term, club.getId());
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }

    public static ArrayList<ClubCourse> queryCourse(String id, String name, String teacher, String term, String clubName) {
        ArrayList<ClubCourse> courses = new ArrayList<>();
        ClubDao clubDao = new ClubDao();
        Club club = clubDao.getClubByName(clubName).get(0);
        courses = courseDao.getCourse(id, name, teacher, term, club.getId());
        if (courses.size() == 0) {
            return null;
        }
        return courses;
    }
}
