package dao.impl;

import dao.UserDAO;
import util.DBUtil;
import vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO
{
    @Override
    public void addUser(String id,String name,String gender,String tel,String job,String nickname,String password)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "insert into user values(?,?,?,?,?,?,?,DEFAULT(position))";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,gender);
            pstmt.setString(4,tel);
            pstmt.setString(5,job);
            pstmt.setString(6,nickname);
            pstmt.setString(7,password);
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
    public String getMaxId()
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql ="select max(id) id from user";
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
    public void deleteUser(String userId)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "delete from user where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
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
    public List<User> findAll()
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setJob(rs.getString("job"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setPosition(rs.getString("position"));
                users.add(user);
            }
            return users;
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
    public List<User> findAttendingUser(String meetingId)//找出参与某会议的所有用户
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from user where id in (select uId from mu where mId = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,meetingId);
            ResultSet rs = pstmt.executeQuery();
            List<User> users = new ArrayList<>();
            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setJob(rs.getString("job"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setPosition(rs.getString("position"));
                users.add(user);
            }
            return users;
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
    public User findById(String userId)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "select * from user where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setJob(rs.getString("job"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setPosition(rs.getString("position"));
                return user;
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
    public void updatePosition(String id,int change)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql ="UPDATE user SET position = position + ? WHERE id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,change);
            pstmt.setString(2,id);
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
}
