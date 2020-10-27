package kz.edu.astanait;

import kz.edu.astanait.Sport.Fifa;
import kz.edu.astanait.Sport.NBA;
import kz.edu.astanait.Sport.NFL;
import kz.edu.astanait.Sport.Sport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/cart",name = "Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String sport = request.getParameter("sport");
        if (action == null) {
            ShowCart(request, response);
        } else {
            if (action.equalsIgnoreCase("add")) {
                AddCart(request, response, sport);
            } else if (action.equalsIgnoreCase("remove")) {
                Remove(request, response);
            }
        }
    }
    public void AddCart(HttpServletRequest request, HttpServletResponse response,String sport) throws ServletException, IOException {
        AbstractFactory kek = FactoryProvider.getFactory("Sport");
        HttpSession session = request.getSession();
        Map<String,Sport> cart;
        if (session.getAttribute("cart")==null){
             cart = new HashMap<>();
        }else{
            cart = (Map<String, Sport>) session.getAttribute("cart");
        }
        if (sport.equals("Fifa")) {
            Fifa fifa = (Fifa) kek.create("Fifa");
            cart.put("fifa",fifa);
        }
        if (sport.equals("NFL")) {
            NFL nfl = (NFL) kek.create("NFL");
            cart.put("nfl",nfl);
        }
        if (sport.equals("NBA")) {
            NBA nba = (NBA) kek.create("NBA");
            cart.put("nba",nba);
        }
        session.setMaxInactiveInterval(60);
        session.setAttribute("cart", cart);
        System.out.println(session.getAttribute("cart"));
        response.sendRedirect(request.getContextPath()+"/jsp/sport-page.jsp");
    }
    protected void ShowCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
    }

    protected void Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String,Sport> cart = (Map<String,Sport>) session.getAttribute("cart");
        cart.remove(request.getParameter("sport"));
        session.setMaxInactiveInterval(60);
        session.setAttribute("cart", cart);
        System.out.println(session.getAttribute("cart"));
        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");

    }

}
