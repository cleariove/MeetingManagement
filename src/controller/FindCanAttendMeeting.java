package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.MeetingService;
import vo.Meeting;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindCanAttendMeeting",urlPatterns = "/findCanAttendMeeting")
public class FindCanAttendMeeting extends HttpServlet
{

    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        List<Meeting> meetings = meetingService.findNotAttendedMeeting(user.getId());
        if(meetings!=null)
        {
            response.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(meetings);
            response.getWriter().write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
