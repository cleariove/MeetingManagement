package controller;

import service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddMeetingController",urlPatterns = "/addMeeting")
public class AddMeetingController extends HttpServlet
{

    private MeetingService meetingService = new MeetingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        String content = request.getParameter("content");
        String accommodation = request.getParameter("accommodation");
        String organizer = request.getParameter("organizer");
        boolean needName = Boolean.parseBoolean(request.getParameter("needName"));
        boolean needJob = Boolean.parseBoolean(request.getParameter("needJob"));
        boolean needTel = Boolean.parseBoolean(request.getParameter("needTel"));
        boolean needGender = Boolean.parseBoolean(request.getParameter("needGender"));
        meetingService.createMeeting(name,date,address,accommodation,content,needName,needJob,needTel,needGender,organizer);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
