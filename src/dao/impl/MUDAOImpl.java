package dao.impl;

import dao.MUDAO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MUDAOImpl implements MUDAO
{
    @Override
    public void insertRecord(String mId,String uId,boolean needRoom)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "insert into mu values (?,?,?,null,null,null,null)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,mId);
            pstmt.setString(2,uId);
            pstmt.setBoolean(3,needRoom);
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
    public void updateName(String mId, String name)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "update mu set name = ? where mId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,mId);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGender(String mId, String gender)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "update mu set gender = ? where mId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,gender);
            pstmt.setString(2,mId);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateJob(String mId, String job)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "update mu set job = ? where mId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,job);
            pstmt.setString(2,mId);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTel(String mId, String tel)
    {
        Connection conn = DBUtil.getConnection();
        try
        {
            String sql = "update mu set tel = ? where mId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tel);
            pstmt.setString(2,mId);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
