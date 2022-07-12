package kz.bitlab.javapro.servlets;

import kz.bitlab.javapro.db.DBConnector;
import kz.bitlab.javapro.model.Blog;
import kz.bitlab.javapro.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("ONLINE_USER");
        if(currentUser!=null) {
            request.setAttribute("currentUser", currentUser);
        }

        ArrayList<Blog> blogs = DBConnector.getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
