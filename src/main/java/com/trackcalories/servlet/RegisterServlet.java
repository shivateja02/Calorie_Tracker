package com.trackcalories.servlet;

import com.trackcalories.model.User;
import com.trackcalories.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setGender(request.getParameter("gender"));
        user.setHeight(Integer.parseInt(request.getParameter("height")));
        user.setWeight(Integer.parseInt(request.getParameter("weight")));
        user.setTargetWeight(Integer.parseInt(request.getParameter("target_weight")));

        try {
            int userId = userDao.registerUser(user);

            if (userId > 0) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);
                session.setAttribute("userName", user.getName());
                response.sendRedirect("daily_inputs.jsp");
            } else {
                request.setAttribute("message", "Registration failed. Please try again.");
                request.getRequestDispatcher("result.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
