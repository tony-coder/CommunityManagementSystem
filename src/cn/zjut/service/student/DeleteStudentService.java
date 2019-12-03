package cn.zjut.service.student;

import cn.zjut.dao.StudentDao;

public class DeleteStudentService {
    public static boolean deleteStudent(String id) {
        StudentDao studentDao = new StudentDao();
        return studentDao.deleteStudent(id);
    }
}
