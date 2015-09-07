package com.working.db;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by Ярослав on 03.09.2015.
 */
public class MainServlet extends HttpServlet {
    Connection dbConnection = null;
    Statement statement = null;
    String selectTableSQL = "SELECT * FROM world.city";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");

        out.print(Database.getConnection().toString());

        try {
            Connection dbConnection =Database.getConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);


            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                out.print("<h1>Hello Servlet </h1>"+ rs.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
