package service;

import dao.MeetingDAO;
import dao.impl.MeetingDAOImpl;
import org.junit.Test;
import vo.Meeting;

import java.sql.Date;
import java.util.List;

public class MeetingService
{

    private MeetingDAO meetingDAO = new MeetingDAOImpl();


    public void createMeeting(String name, Date date, String address, String accommodation, String content,boolean needName,boolean needJob,boolean needTel,boolean needGender,String organizer)
    {
        String maxId = meetingDAO.getMaxId();
        String newId;
        if(maxId == null)
            newId = "100000";
        else
            newId = String.valueOf((Integer.parseInt(maxId) + 1));
        meetingDAO.addMeeting(newId, name, date, address, accommodation, content, needName, needJob, needTel, needGender,organizer);
    }

    public List<Meeting> findAll()
    {
        return meetingDAO.findAll();
    }

    public List<Meeting> findPassedMeeting()
    {
        return meetingDAO.findPassedMeeting();
    }

    public Meeting findByMeetingId(String id)
    {
        return meetingDAO.findByMeetingId(id);
    }

    public void deleteMeeting(String id)
    {
        meetingDAO.deleteMeeting(id);
    }

    public List<Meeting> findAttendedMeeting(String userId)//找出某用户参与的会议
    {
        return meetingDAO.findAttendedMeeting(userId);
    }

    public List<Meeting> findNotAttendedMeeting(String userId)//找出某用户没有参与的会议
    {
        return meetingDAO.findNotAttendedMeeting(userId);
    }

    public void passMeetingById(String id)
    {
        meetingDAO.passMeetingById(id);
    }
}
