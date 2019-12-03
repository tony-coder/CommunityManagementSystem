package cn.zjut.service.student;

import cn.zjut.dao.StudentDao;

public class DeleteStuCourseService {
    public static boolean deleteStuCourse(String studentId, String courseId, String term) {
        StudentDao studentDao = new StudentDao();
        return studentDao.deleteStuCourse(studentId, courseId, term);
    }
}
