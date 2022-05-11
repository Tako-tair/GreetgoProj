package delete_servlet;

import db_engine.Db_controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        PrintWriter writer = resp.getWriter();
        try{
            id = Integer.parseInt(req.getParameter("id"));
        }catch (Exception e){
            System.out.println("Для удаления не прихдить ID");
        }
        Db_controller db = new Db_controller();
        if(id != -1){
            try{
                db.delete_user(id);
                resp.sendRedirect("mainPage.jsp");
            }catch (Exception e){
                System.out.println("проблема при удалений");
            }
        }else {
            writer.println("Delete function is not working");
        }
    }
}
