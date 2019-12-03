package cn.zjut.servlet;

import cn.zjut.bean.Admin;
import cn.zjut.bean.Student;
import cn.zjut.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        //获取用户类型、用户名、密码
        String type = request.getParameter("type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message = LoginService.checkPassword(username, password, type);
        request.setAttribute("message", message);
        if (message.equals("用户名不存在") || message.equals("用户名或密码错误")) {
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else if (message.equals("登陆成功")) {
            if (type.equals("学生")) {
                Student student = LoginService.getStudent(username);
                session.setAttribute("user", student);
                session.setAttribute("type", "student");
                request.getRequestDispatcher("/index.jsp").forward(request, response);  //请求转发
            } else if (type.equals("管理员")) {
                Admin admin = LoginService.getAdmin(username);
                session.setAttribute("user", admin);
                session.setAttribute("type", "admin");
                request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
