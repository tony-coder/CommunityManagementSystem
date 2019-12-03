package cn.zjut.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ClubFilter", urlPatterns = {"/jsp/club.jsp"})
public class ClubFilter extends HttpFilter {
    public void destroy() {
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //super.doFilter(request, response, chain);
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else if (request.getParameter("clubId") == null) {
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("index.jsp");
        } else {  //已登录
            request.getRequestDispatcher("/student/club.do").forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
