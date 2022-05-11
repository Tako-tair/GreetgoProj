package regis_servlet;

import db_engine.Db_controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Check_registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        Db_controller db = new Db_controller();
        db.sing_up_user(login,pass);
        resp.sendRedirect("index.jsp");
    }
}
