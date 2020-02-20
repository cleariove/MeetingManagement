package controller;

import service.MUService;
import service.MeetingService;
import vo.Meeting;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AttendMeetingController",urlPatterns = "/attendMeeting")
public class AttendMeetingController extends HttpServlet
{

    private MUService muService = new MUService();
    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String meetingId = request.getParameter("meetingId");
        boolean needRoom = Boolean.parseBoolean(request.getParameter("needRoom"));
        User user = (User)request.getSession().getAttribute("user");
        muService.insertRecord(meetingId,user.getId(),needRoom);
        Meeting meeting = meetingService.findByMeetingId(meetingId);
        if(meeting.isNeedGender())
            muService.updateGender(meetingId,user.getGender());
        if(meeting.isNeedJob())
            muService.updateJob(meetingId,user.getJob());
        if(meeting.isNeedName())
            muService.updateName(meetingId,user.getName());
        if(meeting.isNeedTel())
            muService.updateTel(meetingId,user.getTel());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}
