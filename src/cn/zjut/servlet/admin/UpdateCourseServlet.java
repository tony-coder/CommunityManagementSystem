package cn.zjut.servlet.admin;

import cn.zjut.service.course.UpdateCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCourseServlet", urlPatterns = {"/admin/updateCourse.do"})
public class UpdateCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("insertId");
        String name = request.getParameter("insertName");
        String teacher = request.getParameter("insertTeacher");
        String term = request.getParameter("insertTerm");
        String clubName = request.getParameter("insertClubName");
        if (UpdateCourseService.updateCourse(id, name, teacher, term, clubName)) {
            request.getRequestDispatcher("/admin/course.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
