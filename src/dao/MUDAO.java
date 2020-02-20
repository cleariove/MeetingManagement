package dao;

public interface MUDAO
{
    public void insertRecord(String mId,String uId,boolean needRoom);

    public void updateName(String mId,String name);

    public void updateGender(String mId,String gender);

    public void updateJob(String mId,String job);

    public void updateTel(String mId,String tel);
}
