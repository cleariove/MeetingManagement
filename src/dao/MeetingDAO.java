package dao;

import vo.Meeting;

import java.sql.Date;
import java.util.List;

public interface MeetingDAO
{
    public void addMeeting(String id,String name,Date date,String address,String accommodation,String content, boolean needName,boolean needJob,boolean needTel,boolean needGender,String organizer);

    public void deleteMeeting(String meetingId);

    public List<Meeting> findAll();

    public List<Meeting> findPassedMeeting();//找出通过审核的会议

    public Meeting findByMeetingId(String meetingId);

    public String getMaxId();

    public List<Meeting> findAttendedMeeting(String userId);//找出某用户参与的所有会议

    public List<Meeting> findNotAttendedMeeting(String userId);//找出某用户没有参与的会议

    public void passMeetingById(String id);
}
