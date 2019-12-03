package cn.zjut.service.course;

import cn.zjut.bean.Club;
import cn.zjut.dao.StudentDao;

import java.util.ArrayList;

public class InsertStuCourseService {
    public static boolean insertStudentCourse(String stuId, String courseId, String term) {
        StudentDao studentDao = new StudentDao();
        Club club = studentDao.getCourseClub(courseId).get(0);
        ArrayList<Club> stuClubs = studentDao.getStuClubThisTerm(stuId, term);
        if (stuClubs.contains(club)) {  //若学生此学期已经属于该社团
            return studentDao.insertStuCourse(stuId, courseId);
        } else {
            if (!studentDao.insertStuCourse(stuId, courseId))
                return false;
            return studentDao.insertStuClub(stuId, club.getId(), term);
        }
    }
}
