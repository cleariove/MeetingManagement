package controller;

import service.UserService;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountManageController",urlPatterns = "/accountManage")
public class AccountManageController extends HttpServlet
{
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user.getPosition().equals("3"))
        {
            String id = request.getParameter("id");
            boolean change = Boolean.parseBoolean(request.getParameter("change"));
            if (change)
                userService.updatePosition(id, 1);
            else
                userService.updatePosition(id, -1);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
