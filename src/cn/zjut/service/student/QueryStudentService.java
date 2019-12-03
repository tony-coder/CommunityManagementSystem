package cn.zjut.service.student;

import cn.zjut.bean.Student;
import cn.zjut.dao.StudentDao;

import java.util.ArrayList;

public class QueryStudentService {
    private static StudentDao studentDao = new StudentDao();

    public static ArrayList<Student> queryAllStudent() {
        return studentDao.getAllStudents();
    }

    public static ArrayList<Student> queryStudentById(String id) {
        ArrayList<Student> students = new ArrayList<>();
        students = studentDao.getStudentById(id);
        if (students.size() == 0) {
            return null;
        }
        return students;
    }

    public static ArrayList<Student> qyeryStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        students = studentDao.getStudentByName(name);
        if (students.size() == 0) {
            return null;
        }
        return students;
    }

    public static ArrayList<Student> queryStudent(String id, String name) {
        ArrayList<Student> students = new ArrayList<>();
        students = studentDao.getStudent(id, name);
        if (students.size() == 0) {
            return null;
        }
        return students;
    }
}
