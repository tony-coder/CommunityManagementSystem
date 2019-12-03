package cn.zjut.servlet.student;

import cn.zjut.bean.Student;
import cn.zjut.service.course.InsertStuCourseService;
import cn.zjut.service.student.DeleteStuCourseService;
import cn.zjut.util.TermTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentSelectCourseServlet",urlPatterns = {"/student/studentCourseServlet.do"})
public class StudentSelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String courseId = request.getParameter("courseId");
        Student student = (Student) request.getSession().getAttribute("user");
        String term = TermTools.getTerm();
        String stuId = student.getId();
        if (request.getParameter("option").equals("select")) {
            InsertStuCourseService.insertStudentCourse(stuId, courseId, term);
        } else if (request.getParameter("option").equals("delete"))
            DeleteStuCourseService.deleteStuCourse(stuId, courseId, term);
        String url = "../jsp/club.jsp?clubId=" + request.getParameter("clubId");
        response.sendRedirect(url);
    }
}
