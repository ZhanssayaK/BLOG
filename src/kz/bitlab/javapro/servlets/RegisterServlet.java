package kz.bitlab.javapro.servlets;

import kz.bitlab.javapro.db.DBConnector;
import kz.bitlab.javapro.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/register?usererror";

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("full_name");
        String rePassword = request.getParameter("re_password");

        User user = DBConnector.getUser(email);

        if(user==null){
            redirect = "/register?passworderror";
            if(password.equals(rePassword)){
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setFullName(fullName);

                DBConnector.addUser(newUser);
                redirect = "/register?success";
            }
        }

        response.sendRedirect(redirect);

    }
}
