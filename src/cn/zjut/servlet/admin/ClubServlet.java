package cn.zjut.servlet.admin;

import cn.zjut.service.club.QueryClubService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClubServlet", urlPatterns = {"/admin/club.do"})
public class ClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //request.setAttribute("clublist", ClubService.getAllClubs());
        request.setAttribute("clublist", QueryClubService.queryAllClub());

        request.getRequestDispatcher("/WEB-INF/jsp/admin/club.jsp").forward(request, response);
    }
}
