package dao.impl;

import dao.MeetingDAO;
import util.DBUtil;
import vo.Meeting;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOImpl implements MeetingDAO
{
    @Override
    public void addMeeting(String id, String name, Date date, String address, String accommodation, String content,boolean needName,boolean needJob,boolean needTel,boolean needGender,String organizer)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "insert into meeting values(?,?,?,?,?,?,default(status),?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setDate(3,date);
            pstmt.setString(4,address);
            pstmt.setString(5,accommodation);
            pstmt.setString(6,content);
            pstmt.setBoolean(7,needName);
            pstmt.setBoolean(8,needJob);
            pstmt.setBoolean(9,needTel);
            pstmt.setBoolean(10,needGender);
            pstmt.setString(11,organizer);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
    }

    @Override
    public void deleteMeeting(String meetingId)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "delete from meeting where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,meetingId);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
    }

    @Override
    public List<Meeting> findAll()
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from meeting";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Meeting> meetings = new ArrayList<>();
            while(rs.next())
            {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getString("id"));
                meeting.setName(rs.getString("name"));
                meeting.setDate(rs.getDate("date"));
                meeting.setAddress(rs.getString("address"));
                meeting.setAccommodation(rs.getString("accommodation"));
                meeting.setContent(rs.getString("content"));
                meeting.setNeedGender(rs.getBoolean("needGender"));
                meeting.setNeedJob(rs.getBoolean("needJob"));
                meeting.setNeedName(rs.getBoolean("needName"));
                meeting.setNeedTel(rs.getBoolean("needTel"));
                meeting.setStatus(rs.getBoolean("status"));
                meeting.setOrganizer(rs.getString("organizer"));
                meetings.add(meeting);
            }
            return meetings;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Meeting> findPassedMeeting()//找出通过审核的会议
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from meeting where status = 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Meeting> meetings = new ArrayList<>();
            while(rs.next())
            {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getString("id"));
                meeting.setName(rs.getString("name"));
                meeting.setDate(rs.getDate("date"));
                meeting.setAddress(rs.getString("address"));
                meeting.setAccommodation(rs.getString("accommodation"));
                meeting.setContent(rs.getString("content"));
                meeting.setNeedGender(rs.getBoolean("needGender"));
                meeting.setNeedJob(rs.getBoolean("needJob"));
                meeting.setNeedName(rs.getBoolean("needName"));
                meeting.setNeedTel(rs.getBoolean("needTel"));
                meeting.setStatus(rs.getBoolean("status"));
                meeting.setOrganizer(rs.getString("organizer"));
                meetings.add(meeting);
            }
            return meetings;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public Meeting findByMeetingId(String meetingId)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from meeting where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,meetingId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getString("id"));
                meeting.setName(rs.getString("name"));
                meeting.setDate(rs.getDate("date"));
                meeting.setAddress(rs.getString("address"));
                meeting.setAccommodation(rs.getString("accommodation"));
                meeting.setContent(rs.getString("content"));
                meeting.setNeedGender(rs.getBoolean("needGender"));
                meeting.setNeedJob(rs.getBoolean("needJob"));
                meeting.setNeedName(rs.getBoolean("needName"));
                meeting.setNeedTel(rs.getBoolean("needTel"));
                meeting.setStatus(rs.getBoolean("status"));
                meeting.setOrganizer(rs.getString("organizer"));
                return meeting;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public String getMaxId()
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql ="select max(id) id from meeting";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                return  rs.getString("id");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Meeting> findAttendedMeeting(String userId)//找出某用户参与的会议
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from meeting where id in (select mId from mu where uId = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();
            List<Meeting> meetings = new ArrayList<>();
            while(rs.next())
            {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getString("id"));
                meeting.setName(rs.getString("name"));
                meeting.setDate(rs.getDate("date"));
                meeting.setAddress(rs.getString("address"));
                meeting.setAccommodation(rs.getString("accommodation"));
                meeting.setContent(rs.getString("content"));
                meeting.setNeedGender(rs.getBoolean("needGender"));
                meeting.setNeedJob(rs.getBoolean("needJob"));
                meeting.setNeedName(rs.getBoolean("needName"));
                meeting.setNeedTel(rs.getBoolean("needTel"));
                meeting.setStatus(rs.getBoolean("status"));
                meeting.setOrganizer(rs.getString("organizer"));
                meetings.add(meeting);
            }
            return meetings;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Meeting> findNotAttendedMeeting(String userId)//找出某用户没有参与的会议
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from meeting WHERE `status` = 1 and meeting.id !=ALL\n" +
                    "(SELECT mId from mu where uId = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();
            List<Meeting> meetings = new ArrayList<>();
            while(rs.next())
            {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getString("id"));
                meeting.setName(rs.getString("name"));
                meeting.setDate(rs.getDate("date"));
                meeting.setAddress(rs.getString("address"));
                meeting.setAccommodation(rs.getString("accommodation"));
                meeting.setContent(rs.getString("content"));
                meeting.setNeedGender(rs.getBoolean("needGender"));
                meeting.setNeedJob(rs.getBoolean("needJob"));
                meeting.setNeedName(rs.getBoolean("needName"));
                meeting.setNeedTel(rs.getBoolean("needTel"));
                meeting.setStatus(rs.getBoolean("status"));
                meeting.setOrganizer(rs.getString("organizer"));
                meetings.add(meeting);
            }
            return meetings;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void passMeetingById(String id)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "update meeting set status = true WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
