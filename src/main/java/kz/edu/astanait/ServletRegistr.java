package kz.edu.astanait;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

@WebServlet(name = "ServletRegistr")
public class ServletRegistr extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // taking all usernames from init param and setting it in list
        LinkedList<String> users =
                new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("usersList").split(",")));
        LinkedList<String> passwords =
                new LinkedList<String>(Arrays.asList(getServletConfig().getInitParameter("passwordsList").split(",")));
        String user = request.getParameter("userreg");
        String pass = request.getParameter("passreg");

        File file = new File("C:\\Database\\db.rtf");
        if(checkUser(user,users))
        {
            Cookie cookie = new Cookie("errorMessage","There is no such USER");
            response.addCookie(cookie);
            request.getRequestDispatcher("jsp/error.jsp").forward(request,response);
            return;
        }else {
            saveUserList(users,passwords,file);
            getServletContext().setInitParameter("newUsersList",users + user);
            getServletContext().setInitParameter("newPasswordsList",passwords + pass);
        }
        }


    //check username if it is in use
    private boolean checkUser(String u, LinkedList<String> users){
        for(String user : users)
        {
            if(user.equalsIgnoreCase(u))
            {
                return true;
            }
        }

        return false;
    }

    //save user list to db.rtf
    private void saveUserList(LinkedList<String> users, LinkedList<String> passwords,File file) throws IOException {
        String content = "";
        for(int i = 0;i<users.size();++i){
            content += users.get(i) + passwords.get(i) + "\n";
        }
        Files.write(Path.of(file.getPath()), content.getBytes());
    }
}
