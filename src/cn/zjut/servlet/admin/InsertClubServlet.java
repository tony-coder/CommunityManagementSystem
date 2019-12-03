package cn.zjut.servlet.admin;

import cn.zjut.service.club.InsertClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertClubServlet",urlPatterns = {"/admin/insertClub.do"})
public class InsertClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("insertId");
        String name = request.getParameter("insertName");
        String descrip = request.getParameter("insertDescription");

        if (InsertClubService.insertClub(id, name, descrip)) {
            request.getRequestDispatcher("/admin/club.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
