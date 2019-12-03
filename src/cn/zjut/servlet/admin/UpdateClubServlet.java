package cn.zjut.servlet.admin;

import cn.zjut.service.club.UpdateClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateClubServlet", urlPatterns = "/admin/updateClub.do")
public class UpdateClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 一定存在且唯一
        String id = request.getParameter("insertId");
        String name = request.getParameter("insertName");
        String description = request.getParameter("insertDescription");

        if (UpdateClubService.updateclub(id, name, description)) {
            request.getRequestDispatcher("/admin/club.do").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/error/databaseError.jsp").forward(request, response);
        }
    }
}
