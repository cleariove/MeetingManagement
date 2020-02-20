package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.UserService;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet",urlPatterns = "/login")
public class LogInController extends HttpServlet
{
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userService.findById(account);
        ObjectMapper mapper = new ObjectMapper();
        String json;
        if(user == null)
        {
            json = mapper.writeValueAsString("nullAccount");
        }
        else if(password.equals(user.getPassword()))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            json = mapper.writeValueAsString("/findMeeting.jsp");
        }
        else
        {
            json = mapper.writeValueAsString("false");
        }
        PrintWriter out = response.getWriter();
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
