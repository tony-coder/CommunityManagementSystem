package cn.zjut.servlet.admin;

import cn.zjut.service.course.DeleteCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCourseServlet",urlPatterns = {"/admin/deleteCourse.do"})
public class DeleteCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("courseId");
        if (DeleteCourseService.deleteCourseService(id)) {
            request.getRequestDispatcher("/admin/course.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
