package cn.zjut.servlet.admin;

import cn.zjut.service.student.UpdateStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", urlPatterns = {"/admin/updateStudent.do"})
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("insertId");
        String name = request.getParameter("insertName");
        String sex = request.getParameter("insertSex");
        if (UpdateStudentService.updateStudent(id, name, sex)) {
            request.getRequestDispatcher("/admin/student.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
