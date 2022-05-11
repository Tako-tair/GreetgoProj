package login_servlets;

import db_engine.Db_controller;
import user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Check_login extends HttpServlet {
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Db_controller db_controller = new Db_controller();
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        boolean isTrue = db_controller.check_login(login, pass);
        ArrayList<User> arr = db_controller.get_users();
        try {
            if(isTrue){
                resp.sendRedirect("mainPage.jsp");
            }else {
                writer.println("login or password incorrect, pls check!!!");
                writer.println("<a href=\"/MyServer\">Back</a>");
            }
        }finally {
            writer.close();
        }
    }
}
