package service;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import org.junit.Test;
import vo.User;

import java.util.List;

public class UserService
{
    private UserDAO userDAO = new UserDAOImpl();
    private User user;

    public void signUp(String name,String gender,String tel,String job,String nickname,String password)
    {
        String maxId = userDAO.getMaxId();
        String newId;
        if(maxId == null)
            newId = "100000";
        else
            newId = String.valueOf((Integer.parseInt(maxId) + 1));
        System.out.println(newId+","+name+","+gender+","+tel+","+job+","+nickname+","+password);
        userDAO.addUser(newId,name,gender,tel,job,nickname,password);
    }

    public boolean loginUp(String id,String password)
    {
        if(password.equals(user.getPassword()))
        {
            user = userDAO.findById(id);
            return true;
        }
        return false;
    }

    public List<User> findAttendingUser(String meetingId)//找出参与某会议的所有用户
    {
        return userDAO.findAttendingUser(meetingId);
    }

    public void deleteUser(String id)
    {
        userDAO.deleteUser(id);
    }

    public List<User> findAll()
    {
        return userDAO.findAll();
    }

    public User findById(String id)
    {
        return userDAO.findById(id);
    }

    public void updatePosition(String id,int change)
    {
        userDAO.updatePosition(id, change);
    }
}
