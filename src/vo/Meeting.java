package vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Meeting
{
    private String id;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String address;
    private String accommodation;
    private String content;
    private boolean status;//true代表会议审核通过
    private boolean needName;//是否需要填写姓名
    private boolean needJob;//是否需要填写工作
    private boolean needTel;//是否需要填写电话
    private boolean needGender;//是否需要填写性别
    private String organizer;//会议的组织者

    public Meeting()
    {

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAccommodation()
    {
        return accommodation;
    }

    public void setAccommodation(String accommodation)
    {
        this.accommodation = accommodation;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public boolean isNeedName()
    {
        return needName;
    }

    public void setNeedName(boolean needName)
    {
        this.needName = needName;
    }

    public boolean isNeedJob()
    {
        return needJob;
    }

    public void setNeedJob(boolean needJob)
    {
        this.needJob = needJob;
    }

    public boolean isNeedTel()
    {
        return needTel;
    }

    public void setNeedTel(boolean needTel)
    {
        this.needTel = needTel;
    }

    public boolean isNeedGender()
    {
        return needGender;
    }

    public void setNeedGender(boolean needGender)
    {
        this.needGender = needGender;
    }

    public String getOrganizer()
    {
        return organizer;
    }

    public void setOrganizer(String organizer)
    {
        this.organizer = organizer;
    }


}
