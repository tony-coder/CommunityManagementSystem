package cn.zjut.servlet.student;

import cn.zjut.bean.Club;
import cn.zjut.bean.StuCourse;
import cn.zjut.bean.Student;
import cn.zjut.service.club.QueryClubService;
import cn.zjut.service.student.QueryStuCourseService;
import cn.zjut.util.TermTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "StuClubServlet", urlPatterns = {"/student/club.do"})
public class StuClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String clubId = request.getParameter("clubId");
        Club club = QueryClubService.queryClubById(clubId).get(0);
        Student student = (Student) request.getSession().getAttribute("user");
        //本学期
        String term = TermTools.getTerm();
        ArrayList<StuCourse> selectedCourseList = QueryStuCourseService.queryAllSelectedCourseInClub(student.getId(), clubId, term);
        ArrayList<StuCourse> unselectedCourseList = QueryStuCourseService.queryUnselectedCourseInClub(student.getId(), clubId, term);
        request.setAttribute("club", club);
        request.setAttribute("unselectedCourseList", unselectedCourseList);
        request.setAttribute("selectedCourseList", selectedCourseList);
        request.getRequestDispatcher("/jsp/club.jsp").forward(request, response);
    }
}
