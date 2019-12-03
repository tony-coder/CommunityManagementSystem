package cn.zjut.servlet.admin;

import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/admin/student.do"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //request.setAttribute("studentlist", StudentService.getAllStudents());
        request.setAttribute("studentlist", QueryStudentService.queryAllStudent());
        request.getRequestDispatcher("/WEB-INF/jsp/admin/student.jsp").forward(request, response);
    }
}
