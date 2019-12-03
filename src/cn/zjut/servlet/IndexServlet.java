package cn.zjut.servlet;

import cn.zjut.bean.Club;
import cn.zjut.service.club.QueryClubService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IndexServlet", urlPatterns = {"/home.do"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //ArrayList<Club> clubs = IndexService.getAllClubs();
        ArrayList<Club> clubs = QueryClubService.queryAllClub();
        request.setAttribute("clubList", clubs);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/home.jsp");
        rd.forward(request, response);
    }
}
