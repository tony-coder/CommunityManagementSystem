package cn.zjut.servlet.student;

import cn.zjut.bean.Student;
import cn.zjut.service.student.UpdateStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StuUpdatePasswordServlet", urlPatterns = {"/student/updatePassword.do"})
public class StuUpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String password_old = request.getParameter("password_old");
        String password_new = request.getParameter("password_new");
        String password_vary = request.getParameter("password_vary");
        Student student = (Student) request.getSession().getAttribute("user");
        String message = null;
        if (!password_old.equals(student.getPassword())) {
            message = "密码错误";
        } else {
            if (!password_new.equals(password_vary)) {
                message = "两次输入密码不一致";
            } else {
                if (UpdateStudentService.updateStudentPwd(student.getId(), password_new)) {
                    message = "密码更新成功";
                } else {
                    message = "密码更新失败";
                }
            }
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/student/studentStatus.do").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
