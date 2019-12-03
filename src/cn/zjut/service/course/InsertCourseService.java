package cn.zjut.service.course;

import cn.zjut.bean.Club;
import cn.zjut.dao.ClubDao;
import cn.zjut.dao.CourseDao;

public class InsertCourseService {
    public static boolean insertCourse(String id, String name, String teacher, String term,String clubName) {
        ClubDao clubDao = new ClubDao();
        CourseDao courseDao = new CourseDao();
        Club club = clubDao.getClubByName(clubName).get(0);
        return courseDao.insertCourse(id, name, teacher, term, club.getId());
    }
}
