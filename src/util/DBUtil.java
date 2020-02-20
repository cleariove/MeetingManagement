package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/meeting?" +
                    "useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8",
                    "root",
                    "123456");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection conn)
    {
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
