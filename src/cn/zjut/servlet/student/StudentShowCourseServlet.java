package cn.zjut.servlet.student;

import cn.zjut.bean.Student;
import cn.zjut.service.course.DeleteCourseService;
import cn.zjut.service.student.DeleteStuCourseService;
import cn.zjut.service.student.QueryStuCourseService;
import cn.zjut.util.TermTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "StudentShowCourseServlet", urlPatterns = {"/student/myCourse.do"})
public class StudentShowCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Student student = (Student) request.getSession().getAttribute("user");

        if (request.getParameter("option") != null) {
            if (request.getParameter("option").equals("delete")) {
                String courseId = request.getParameter("courseId");
                String term = TermTools.getTerm();
                DeleteStuCourseService.deleteStuCourse(student.getId(), courseId, term);
            }
        }

//        Calendar a = Calendar.getInstance();
//        int currentYear = a.get(Calendar.YEAR);
//        int currentMonth = a.get(Calendar.MONTH) + 1;
////        String currentYear = "" + a.get(Calendar.YEAR);
//        String term;
//        if (currentMonth >= 3 && currentMonth < 9) {
//            term = currentYear + "-" + String.valueOf(currentYear + 1) + "(2)";
//        } else {
//            term = String.valueOf(currentYear) + "-" + String.valueOf(currentYear + 1) + "(1)";
//        }
        String term = TermTools.getTerm();
        request.setAttribute("courselist", QueryStuCourseService.queryStuCourse(term, student.getName()));
        request.setAttribute("term", term);
        request.getRequestDispatcher("/WEB-INF/jsp/student/mycourse.jsp").forward(request, response);
    }
}
