package add_servlet;

import db_engine.Db_controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Add_user extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pr = resp.getWriter();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String school = req.getParameter("school");
        int degree = Integer.parseInt(req.getParameter("degree"));
        double avr_ball = Double.parseDouble(req.getParameter("avr_ball"));
        Db_controller db = new Db_controller();
        db.sing_up_other(name,surname,school,degree,avr_ball);
        resp.sendRedirect("mainPage.jsp");
    }
}
