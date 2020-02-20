<%@ page import="vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/30
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="background-color: grey;text-align: center;">
    <h1 style="display: inline-block">会议管理系统</h1>
    <span style="float: right" id="111">
    欢迎您,<%=((User)session.getAttribute("user")).getNickname()%>！
    </span>
</div>

