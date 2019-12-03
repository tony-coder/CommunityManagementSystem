package cn.zjut.servlet.admin;

import cn.zjut.service.club.QueryClubService;
import cn.zjut.service.course.QueryCourseService;
import cn.zjut.service.student.QueryStuCourseService;
import cn.zjut.service.student.QueryStudentService;
import cn.zjut.util.TermTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StuCourseServlet", urlPatterns = {"/admin/StuCourse.do"})
public class StuCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String selectTerm = request.getParameter("selectTerm");
        request.setAttribute("studentlist", QueryStudentService.queryAllStudent());
        if (selectTerm == null) {
            String term = TermTools.getTerm();  //默认为本学期
            request.setAttribute("term", term);
            request.setAttribute("courselist", QueryCourseService.queryCourseByTerm(term));
        } else {
            request.setAttribute("term", selectTerm);
            request.setAttribute("courselist", QueryCourseService.queryCourseByTerm(selectTerm));
        }
        request.setAttribute("stuCourselist", QueryStuCourseService.getAllStuCourse());
        request.getRequestDispatcher("/WEB-INF/jsp/admin/studentCourse.jsp").forward(request, response);
    }
}
