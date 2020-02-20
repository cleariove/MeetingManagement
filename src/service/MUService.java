package service;

import dao.MUDAO;
import dao.impl.MUDAOImpl;
import org.junit.Test;

public class MUService
{
    private MUDAO muDao = new MUDAOImpl();

    public void insertRecord(String mId,String uId,boolean needRoom)
    {
        muDao.insertRecord(mId, uId, needRoom);
    }

    public void updateName(String mId,String name)
    {
        muDao.updateName(mId, name);
    }

    public void updateGender(String mId,String gender)
    {
        muDao.updateGender(mId, gender);
    }

    public void updateJob(String mId,String job)
    {
        muDao.updateJob(mId, job);
    }

    public void updateTel(String mId,String tel)
    {
        muDao.updateTel(mId, tel);
    }
}
