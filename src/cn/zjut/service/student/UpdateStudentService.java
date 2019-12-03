package cn.zjut.service.student;

import cn.zjut.dao.StudentDao;

public class UpdateStudentService {
    public static boolean updateStudent(String id, String name, String sex) {
        StudentDao studentDao = new StudentDao();
        return studentDao.updateStudent(id, name, sex);
    }

    public static boolean updateStudentPwd(String id, String password) {
        StudentDao studentDao = new StudentDao();
        return studentDao.updateStuPwd(id, password);
    }
}
