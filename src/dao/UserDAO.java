package dao;

import vo.Meeting;
import vo.User;

import java.util.List;

public interface UserDAO
{
    public void addUser(String id,String name,String gender,String tel,String job,String nickname,String password);

    public String getMaxId();

    public void deleteUser(String userId);

    public List<User> findAll();

    public List<User> findAttendingUser(String meetingId);//找出参与某会议的所有用户

    public User findById(String userId);

    public void updatePosition(String id,int change);
}
