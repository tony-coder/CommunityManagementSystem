package cn.zjut.servlet.admin;

import cn.zjut.service.student.DeleteStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", urlPatterns = {"/admin/deleteStudent.do"})
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("studentId");
        if (DeleteStudentService.deleteStudent(id)) {
            request.getRequestDispatcher("/admin/student.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
