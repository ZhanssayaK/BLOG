package kz.bitlab.javapro.servlets;

import kz.bitlab.javapro.db.DBConnector;
import kz.bitlab.javapro.model.Blog;
import kz.bitlab.javapro.model.Comment;
import kz.bitlab.javapro.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readblog")
public class BlogDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("ONLINE_USER");
        if(currentUser!=null) {
            request.setAttribute("currentUser", currentUser);
        }

        Long blogId = Long.parseLong(request.getParameter("id"));
        Blog blog = DBConnector.getBlog(blogId);
        request.setAttribute("blog", blog);

        if(blog!=null){
            ArrayList<Comment> comments = DBConnector.getAllComments(blogId);
            request.setAttribute("comments", comments);
        }

        request.getRequestDispatcher("/blogdetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
