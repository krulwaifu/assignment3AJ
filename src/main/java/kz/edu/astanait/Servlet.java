package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    public void genreCheck(HttpServletRequest request, HttpServletResponse response,String genre) throws IOException {
        if (genre.equalsIgnoreCase("Sport Games")){

            response.sendRedirect(request.getContextPath() + "/jsp/sport-page.jsp");

        }else if (genre.equalsIgnoreCase("RPG Games")){

            response.sendRedirect(request.getContextPath() + "/jsp/rpg-page.jsp");

        }else if (genre.equalsIgnoreCase("Racing Games")){

            response.sendRedirect(request.getContextPath() + "/jsp/racing-page.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String genre = request.getParameter("genre");
        genreCheck(request,response,genre);
    }
}
