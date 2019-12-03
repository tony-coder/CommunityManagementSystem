package cn.zjut.servlet.admin;

import cn.zjut.service.club.QueryClubService;
import cn.zjut.service.course.QueryCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CourseServlet", urlPatterns = {"/admin/course.do"})
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //request.setAttribute("courselist", CourseService.getAllCourses());
        request.setAttribute("courselist", QueryCourseService.queryAllCourse());
        request.setAttribute("clublist", QueryClubService.queryAllClub());
        request.getRequestDispatcher("/WEB-INF/jsp/admin/course.jsp").forward(request, response);
    }
}
