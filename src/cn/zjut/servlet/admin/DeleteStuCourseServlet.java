package cn.zjut.servlet.admin;

import cn.zjut.bean.Course;
import cn.zjut.bean.Student;
import cn.zjut.service.course.QueryCourseService;
import cn.zjut.service.student.DeleteStuCourseService;
import cn.zjut.service.student.QueryStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStuCourseServlet", urlPatterns = {"/admin/deleteStuCourse.do"})
public class DeleteStuCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String stuName = request.getParameter("studentName");
        String courseName = request.getParameter("courseName");
        String term = request.getParameter("term");
        Student student = QueryStudentService.qyeryStudentByName(stuName).get(0);
        Course course = QueryCourseService.queryCourseByTermName(term, courseName).get(0);
        if (DeleteStuCourseService.deleteStuCourse(student.getId(), course.getId(), term)) {
            request.getRequestDispatcher("/admin/StuCourse.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
