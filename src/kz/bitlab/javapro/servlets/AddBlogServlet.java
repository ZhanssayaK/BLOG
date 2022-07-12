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

@WebServlet(value = "/addblog")
public class AddBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("ONLINE_USER");
        if(currentUser!=null) {
            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("/addblog.jsp").forward(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        User currentUser = (User) request.getSession().getAttribute("ONLINE_USER");
        if(currentUser!=null) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Blog blog = new Blog();
            blog.setTitle(title);
            blog.setContent(content);
            blog.setUser(currentUser);

            DBConnector.addBlog(blog);
            response.sendRedirect("/addblog");

        }else{
            response.sendRedirect("/login");
        }
    }
}
