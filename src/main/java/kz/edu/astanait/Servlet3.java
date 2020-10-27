package kz.edu.astanait;

import kz.edu.astanait.RPG.Cyberpunk;
import kz.edu.astanait.RPG.DarkSouls;
import kz.edu.astanait.RPG.RPG;
import kz.edu.astanait.RPG.Witcher;
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

@WebServlet(urlPatterns = "/Servlet3",name = "Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String sport = request.getParameter("rpg");
        if (action == null) {
            ShowCart(request, response);
        } else {
            if (action.equalsIgnoreCase("add")) {
                AddCart(request, response, sport);
                response.sendRedirect(request.getContextPath()+"/jsp/rpg-page.jsp");
            } else if (action.equalsIgnoreCase("remove")) {
                Remove(request, response);
            }
        }
    }
    public void AddCart(HttpServletRequest request, HttpServletResponse response,String sport) throws ServletException, IOException {
        AbstractFactory kek = FactoryProvider.getFactory("RPG");
        HttpSession session = request.getSession();
        Set<RPG> cart2;
        if (session.getAttribute("cart")==null){
            cart2 = new HashSet<>();
        }else{
            cart2 = (Set<RPG>) session.getAttribute("cart2");
        }
        if (sport.equals("Cyberpunk")) {
            Cyberpunk cyberpunk = (Cyberpunk) kek.create("Cyberpunk");
            cart2.add((RPG) cyberpunk);
        } else if (sport.equals("Witcher")) {
            Witcher witcher = (Witcher) kek.create("Witcher");
            cart2.add((RPG) witcher);
        } else if (sport.equals("Dark Souls")) {
            DarkSouls darkSouls = (DarkSouls) kek.create("Dark Souls");
            cart2.add((RPG) darkSouls);
        }
        session.setMaxInactiveInterval(60);
        session.setAttribute("cart2", cart2);
    }
    protected void ShowCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/cart2.jsp").forward(request, response);
    }

    protected void Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Set<RPG> cart2 = (Set<RPG>) session.getAttribute("cart2");
        if (cart2.contains(request.getParameter("rpg"))){
        cart2.remove(request.getParameter("rpg"));
            session.setMaxInactiveInterval(60);
            session.setAttribute("cart2", cart2);
        }
        response.sendRedirect("jsp/cart2.jsp");
    }

}
