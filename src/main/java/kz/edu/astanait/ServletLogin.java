package kz.edu.astanait;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    //checking login form username and password
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<String> users;
        LinkedList<String> passwords;
        int c = 0;
        Cookie cookie;
        if (getServletConfig().getInitParameter("usersList1")!= null){
            users =
                    new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("newUsersList").split(",")));
            passwords =
                    new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("newPasswordsList").split(",")));
        }else {
            users =
                    new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("usersList").split(",")));
            passwords =
                    new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("passwordsList").split(",")));
        }
        if (users.size()==passwords.size()){
        for(int i =0;i<users.size();i++){
            if (request.getParameter("user").equalsIgnoreCase(users.get(i))
                    && request.getParameter("password").equalsIgnoreCase(passwords.get(i))){
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                HttpSession userSession = request.getSession();
                userSession.setAttribute("user",user);
                HttpSession passwordSession = request.getSession();
                passwordSession.setAttribute("password",password);
                c++;
            }
        }//if username and password is correct
        if (c==1){
            response.sendRedirect(request.getContextPath()+"/jsp/categories.jsp");
        }
        //if username and password is incorrect
        else {
            cookie = new Cookie("errorMessage","There is no such USER");
            response.addCookie(cookie);
            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);
        }
        }
        //if there is the error in database the number of usernames is not equal to number of passwords
        else {
            response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
            cookie = new Cookie("errorMessage","Error in database sorry");
            response.addCookie(cookie);
            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
