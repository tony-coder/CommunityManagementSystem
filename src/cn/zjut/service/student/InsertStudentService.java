package cn.zjut.service.student;

import cn.zjut.dao.StudentDao;

public class InsertStudentService {
    public static boolean insertStudent(String id, String name, String sex, String password) {
        StudentDao studentDao = new StudentDao();
        return studentDao.insertStudent(id, name, sex, password);
    }
}
