package cn.zjut.servlet.student;

import cn.zjut.bean.Student;
import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentStatusServlet", urlPatterns = {"/student/studentStatus.do"})
public class StudentStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Student student = (Student) request.getSession().getAttribute("user");
        request.setAttribute("student", student);
        request.getRequestDispatcher("/WEB-INF/jsp/student/studentPassword.jsp").forward(request, response);
    }
}
