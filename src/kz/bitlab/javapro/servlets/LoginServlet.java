package kz.bitlab.javapro.servlets;

import kz.bitlab.javapro.db.DBConnector;
import kz.bitlab.javapro.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login?usererror";
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = DBConnector.getUser(email);

        if(user!=null){
            redirect = "/login?passworderror";
            if(user.getPassword().equals(password)){
                request.getSession().setAttribute("ONLINE_USER", user);
                redirect = "/profile";
            }
        }

        response.sendRedirect(redirect);

    }
}
