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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindMyOrganizeController",urlPatterns = "/findMyOrganize")
public class FindMyOrganizeController extends HttpServlet
{
    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Meeting> meetings;
        meetings = meetingService.findPassedMeeting();
        meetings.removeIf(e->!e.getOrganizer().equals(user.getName()));
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(meetings);
        PrintWriter out = response.getWriter();
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
