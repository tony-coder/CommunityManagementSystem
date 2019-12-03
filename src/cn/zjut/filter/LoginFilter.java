package cn.zjut.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/jsp/mycourse.jsp"})
public class LoginFilter extends HttpFilter {
    private FilterConfig config;

    public void destroy() {
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取应用上下文对象
        ServletContext context = config.getServletContext();

        HttpSession session = request.getSession();
        //已登录
        if (session.getAttribute("user") != null) {
            if (((String) session.getAttribute("type")).equals("admin")) {
                request.getRequestDispatcher("/admin/course.do").forward(request, response);
            } else if (((String) session.getAttribute("type")).equals("student")) {
                request.getRequestDispatcher("/student/myCourse.do").forward(request, response);
            }
        } else {  //未登录
            //chain.doFilter(request, response);
            response.sendRedirect("login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
