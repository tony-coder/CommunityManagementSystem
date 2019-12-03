package cn.zjut.servlet.admin;

import cn.zjut.bean.Student;
import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QueryStudentServlet", urlPatterns = {"/admin/queryStudent.do"})
public class QueryStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("student_id");
        String name = request.getParameter("student_name");

        ArrayList<Student> students;
        if (id.equals("") && name.equals("")) {
            students = QueryStudentService.queryAllStudent();
        } else if (!id.equals("") && name.equals("")) {
            students = QueryStudentService.queryStudentById(id);
        } else if (id.equals("") && !name.equals("")) {
            students = QueryStudentService.qyeryStudentByName(name);
        } else {
            students = QueryStudentService.queryStudent(id, name);
        }

        request.setAttribute("studentlist", students);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/student.jsp").forward(request, response);
    }
}
