package controller;

import service.MeetingService;
import vo.Meeting;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuditController",urlPatterns = "/auditMeeting")
public class AuditController extends HttpServlet
{
    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user.getId().equals("2")||user.getId().equals("3"))
        {
            String id = request.getParameter("id");
            boolean pass = Boolean.parseBoolean(request.getParameter("pass"));
            if (pass)
            {
                meetingService.passMeetingById(id);
            } else
            {
                meetingService.deleteMeeting(id);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
