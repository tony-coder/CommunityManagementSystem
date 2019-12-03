package cn.zjut.servlet.admin;

import cn.zjut.bean.ClubCourse;
import cn.zjut.bean.Course;
import cn.zjut.service.club.QueryClubService;
import cn.zjut.service.course.QueryCourseService;
import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QueryCourseServlet", urlPatterns = {"/admin/queryCourse.do"})
public class QueryCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String term = request.getParameter("term");
        String clubName = request.getParameter("ClubName");
        ArrayList<ClubCourse> courses = null;
        /**
         * 太麻烦了。。。用mybatis就不会有这么多判断了。。
         */
        if (!id.equals("") && !name.equals("") && !teacher.equals("") && term != null && clubName != null) {
            courses = QueryCourseService.queryCourse(id, name, teacher, term, clubName);
        } else if (id.equals("") && name.equals("") && teacher.equals("") && term != null && clubName == null) {
            courses = QueryCourseService.queryCourseByTerm(term);
        } else if (id.equals("") && !name.equals("") && teacher.equals("") && term != null && clubName == null) {
            courses = QueryCourseService.queryCourseByTermName(term, name);
        } else if (!id.equals("") && name.equals("") && teacher.equals("") && term != null && clubName == null) {
            courses = QueryCourseService.queryCourseByTermId(term, id);
        } else if (id.equals("") && name.equals("") && !teacher.equals("") && term != null && clubName == null) {
            courses = QueryCourseService.queryCourseByTermTeacher(term, teacher);
        } else if (id.equals("") && !name.equals("") && teacher.equals("") && term == null && clubName == null) {
            courses = QueryCourseService.queryCourseByName(name);
        } else if (!id.equals("") && name.equals("") && teacher.equals("") && term == null && clubName == null) {
            courses = QueryCourseService.queryCourseById(id);
        } else if (id.equals("") && name.equals("") && !teacher.equals("") && term == null && clubName == null) {
            courses = QueryCourseService.queryCourseByTeacher(teacher);
        } else if (id.equals("") && name.equals("") && teacher.equals("") && term == null && clubName != null) {
            courses = QueryCourseService.queryCourseByClubName(clubName);
        } else if (id.equals("") && name.equals("") && teacher.equals("") && term != null && clubName != null) {
            courses = QueryCourseService.queryCourseByTermClubName(term, clubName);
        } else {
            courses = QueryCourseService.queryAllCourse();
        }
        request.setAttribute("clublist", QueryClubService.queryAllClub());
        request.setAttribute("courselist", courses);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/course.jsp").forward(request, response);
    }
}
