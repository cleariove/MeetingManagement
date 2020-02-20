package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddUserController",urlPatterns = "/addUser")
public class AddUserController extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserService userService = new UserService();
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        userService.signUp(name,gender,tel,job,nickname,password);
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "{\"url:\"+\"index.jsp\"}";
//        String url = "/index.jsp";
        String json = objectMapper.writeValueAsString("/index.jsp");
//        String str = objectMapper.writeValueAsString("hhhhh");
        out.write(json);
//        out.write(str);

        out.flush();
        out.close();
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
