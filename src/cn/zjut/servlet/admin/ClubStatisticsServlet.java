package cn.zjut.servlet.admin;

import cn.zjut.bean.ClubCount;
import cn.zjut.service.club.CountClubService;
import cn.zjut.util.TermTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClubStatisticsServlet", urlPatterns = {"/admin/clubStatistics.do"})
public class ClubStatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String term = request.getParameter("selectTerm");
        if (term != null) {
            ArrayList<ClubCount> clubCounts = CountClubService.getClubStatisticByTerm(term);
            request.setAttribute("clubStatisticsLabels", CountClubService.getClubStatisticLabels(clubCounts));
            request.setAttribute("clubStatisticsValue", CountClubService.getClubStatisticValue(clubCounts));
        } else {
            term = TermTools.getTerm();  //默认为本学期
            ArrayList<ClubCount> clubCounts = CountClubService.getClubStatisticByTerm(term);
            request.setAttribute("clubStatisticsLabels", CountClubService.getClubStatisticLabels(clubCounts));
            request.setAttribute("clubStatisticsValue", CountClubService.getClubStatisticValue(clubCounts));
        }
        request.getRequestDispatcher("/WEB-INF/jsp/admin/statistics.jsp").forward(request, response);
    }
}
