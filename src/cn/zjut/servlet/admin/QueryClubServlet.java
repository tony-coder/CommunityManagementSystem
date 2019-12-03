package cn.zjut.servlet.admin;

import cn.zjut.bean.Club;
import cn.zjut.service.club.QueryClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QueryClubServlet", urlPatterns = {"/admin/queryClub.do"})
public class QueryClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("club_id");
        String name = request.getParameter("club_name");

        ArrayList<Club> clubs;
        if (id.equals("") && name.equals("")) {
            clubs = QueryClubService.queryAllClub();
        } else if (!id.equals("") && name.equals("")) {
            clubs = QueryClubService.queryClubById(id);
        } else if (id.equals("") && !name.equals("")) {
            clubs = QueryClubService.queryClubByName(name);
        } else {
            clubs = QueryClubService.queryClub(id, name);
        }

        request.setAttribute("clublist", clubs);
        request.getRequestDispatcher("/WEB-INF/jsp/admin/club.jsp").forward(request, response);

    }
}
