package cn.zjut.servlet.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ImageUploadServlet", urlPatterns = {"/admin/uploadImage.do"})
@MultipartConfig(location = "D:\\", fileSizeThreshold = 1024)  //必须使用
public class ImageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回web应用程序文档根目录
        String path = request.getSession().getServletContext().getRealPath("");
//        String path = "C:\\Users\\lenovo\\IdeaProjects\\CommunityManagementSystem\\web\\";
//        System.out.println(path);
        String id = request.getParameter("clubId");
        Part p = request.getPart("fileName");

        String message = "";
        if (p.getSize() > 1024 * 1024) {  //上传的文件不能超过1MB大小
            p.delete();
            message = "图片太大，不能上传";
        } else {
            path = path + "images\\clubs\\" + id;
            File f = new File(path);
            if (!f.exists()) {  //若目录不存在，则创建目录
                f.mkdirs();
            }
            String h = p.getHeader("content-disposition");
            //得到文件名
            //例：Content-Disposition:from-data;name="filename";filename="C:\study\HelloWorld.java"
            String fname = h.substring(h.lastIndexOf(";") + 12, h.length() - 1);
            fname = "thumbnail.jpg";
            String filepath = path + "\\" + fname;
            System.out.println(filepath);

            p.write(filepath);
            message = ("图片上传成功");
        }
        request.setAttribute("message", message);
        System.out.println(message);
        RequestDispatcher rd = request.getRequestDispatcher("/admin/club.do");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
