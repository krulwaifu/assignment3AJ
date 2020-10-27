package kz.edu.astanait;

import kz.edu.astanait.Racing.AsettoCorsa;
import kz.edu.astanait.Racing.NFS;
import kz.edu.astanait.Racing.ProjectCars;
import kz.edu.astanait.Racing.Racing;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/cart",name = "Servlet2")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String sport = request.getParameter("racing");
        if (action == null) {
            ShowCart(request, response);
        } else {
            if (action.equalsIgnoreCase("add")) {
                AddCart(request, response, sport);
                response.sendRedirect(request.getContextPath()+"/jsp/racing-page.jsp");
            } else if (action.equalsIgnoreCase("remove")) {
                Remove(request, response);
            }
        }
    }
    public void AddCart(HttpServletRequest request, HttpServletResponse response,String sport) throws ServletException, IOException {
        AbstractFactory kek = FactoryProvider.getFactory("Sport");
        HttpSession session = request.getSession();
        Map<String,Racing> cart;
        if (session.getAttribute("cart")==null){
            cart = new HashMap<>();
        }else{
            cart = (Map<String, Racing>) session.getAttribute("cart");
        }
        if (sport.equals("Assetto Corsa")) {
            AsettoCorsa asettoCorsa = (AsettoCorsa) kek.create("Assetto Corsa");
            cart.put("asettoCorsa",asettoCorsa);
        } else if (sport.equals("Need for Speed")) {
            NFS nfs = (NFS) kek.create("Need for Speed");
            cart.put("nfs",nfs);
        } else if (sport.equals("Project Cars 2")) {
            ProjectCars projectCars = (ProjectCars) kek.create("Project Cars 2");
            cart.put("projectCars",projectCars);
        }
        session.setMaxInactiveInterval(60);
        session.setAttribute("cart", cart);
    }
    protected void ShowCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
    }

    protected void Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String,Racing> cart = (Map<String,Racing>) session.getAttribute("cart");
        if (cart.containsKey(request.getParameter("racing"))){
        cart.remove(request.getParameter("racing"));
            session.setMaxInactiveInterval(60);
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("jsp/cart.jsp");

    }

}
