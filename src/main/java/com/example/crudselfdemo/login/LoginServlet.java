package com.example.crudselfdemo.login;

import com.example.crudselfdemo.modal.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private LoginDao loginDao = new LoginDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        User user = loginDao.getUserByUsernameAndPasswod(username, password);

        if(user != null)
        {
            HttpSession session = request.getSession();

            session.setAttribute("username", user.getUsername());

            session.setAttribute("email", user.getEmail());

            response.sendRedirect(request.getContextPath() + "/employee-list.do");
        }
        else
        {
            request.setAttribute("errorMessage", "Invalid Username or Password!");

            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        }

    }
}
