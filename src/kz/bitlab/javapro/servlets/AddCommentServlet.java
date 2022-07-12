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

@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        User currentUser = (User) request.getSession().getAttribute("ONLINE_USER");
        if(currentUser!=null) {

            String commentText = request.getParameter("comment");
            Long blogId = Long.parseLong(request.getParameter("blog_id"));
            Blog blog = DBConnector.getBlog(blogId);

            if(blog!=null) {

                Comment comment = new Comment();
                comment.setUser(currentUser);
                comment.setComment(commentText);
                comment.setBlog(blog);
                DBConnector.addComment(comment);

                response.sendRedirect("/readblog?id="+blogId);

            }else{
                response.sendRedirect("/");
            }

        }else{
            response.sendRedirect("/login");
        }
    }
}