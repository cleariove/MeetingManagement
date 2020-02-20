<%@ page import="vo.User" %><%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/30
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div class="listTitle">个人中心</div>
    <ul type="none" id="personalCenter">
        <script>
            var position = <%=((User)session.getAttribute("user")).getPosition()%>;
            var content = "<li><a href=\"findAttendMeeting.jsp\">我的会议</a></li>";
            if(position =="3")
            {
                content += "<li><a href=\"findAllUser.jsp\">用户管理</a></li>";
            }
            document.getElementById("personalCenter").innerHTML = content;
        </script>
    </ul>
    <div class="listTitle">会议中心</div>
    <ul type="none">
        <li><a href="findMeeting.jsp">所有会议</a></li>
        <li><a href="attendMeeting.jsp">预定会议</a></li>
        <li><a href="addMeeting.jsp">申请会议</a></li>
        <li><a href="findMyOrganize.jsp">我组织的</a></li>
    </ul>

</div>

