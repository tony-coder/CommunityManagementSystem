package cn.zjut.servlet.admin;

import cn.zjut.service.student.QueryStuCourseService;
import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryStuCourseServlet", urlPatterns = {"/admin/queryStuCourse.do"})
public class QueryStuCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String term = request.getParameter("term");
        String stuName = request.getParameter("stuName");
        request.setAttribute("studentlist", QueryStudentService.queryAllStudent());
        if (term != null && !stuName.equals("")) {
            request.setAttribute("stuCourselist", QueryStuCourseService.queryStuCourse(term, stuName));
        } else if (term != null && stuName.equals("")) {
            request.setAttribute("stuCourselist", QueryStuCourseService.queryStuCourseByTerm(term));
        } else if (term == null && !stuName.equals("")) {
            request.setAttribute("stuCourselist", QueryStuCourseService.queryStuCourseByName(stuName));
        }
        request.getRequestDispatcher("/WEB-INF/jsp/admin/studentCourse.jsp").forward(request, response);
    }
}
