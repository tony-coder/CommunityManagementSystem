package cn.zjut.service.course;

import cn.zjut.dao.CourseDao;

public class DeleteCourseService {
    public static boolean deleteCourseService(String id) {
        CourseDao courseDao = new CourseDao();
        return courseDao.deleteCourse(id);
    }
}
