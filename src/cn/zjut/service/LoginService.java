package cn.zjut.service;

import cn.zjut.bean.Admin;
import cn.zjut.bean.Student;
import cn.zjut.dao.AdminDao;
import cn.zjut.dao.StudentDao;

public class LoginService {
    public static String checkPassword(String username, String password, String type) {
        String result = null;
        if (type.equals("管理员")) {
            AdminDao adminDao = new AdminDao();
            Admin admin = adminDao.queryAdminPwd(username);
            if (admin == null) {
                result = "用户名不存在";
            } else {
                String realpassword = admin.getPassword().trim();
                if (realpassword.equals(password)) {
                    result = "登陆成功";
                } else {
                    result = "用户名或密码错误";
                }
            }
        } else if (type.equals("学生")) {
            StudentDao studentDao = new StudentDao();
            Student student = studentDao.queryStuPwd(username);
            if (student == null) {
                result = "用户名不存在";
            } else {
                String realpassword = student.getPassword().trim();
                if (realpassword.equals(password)) {
                    result = "登陆成功";
                } else {
                    result = "用户名或密码错误";
                }
            }
        }
        return result;
    }

    public static Admin getAdmin(String username) {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.queryAdminPwd(username);
        return admin;
    }

    public static Student getStudent(String username) {
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.queryStuPwd(username);
        return student;
    }
}
