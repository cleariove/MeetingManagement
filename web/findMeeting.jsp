<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/30
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="vo.Meeting" %>--%>
<%--<%@ page import="vo.User" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的会议</title>
    <link rel="stylesheet" href="css/common.css"/>
</head>
<body onload="showAllMeeting()">
<jsp:include page="top.jsp"/>
    <div class="leftMenu">
        <jsp:include page="leftMenu.jsp"/>
    </div>
    <div class="content">
        <table  border="1 solid" id="findAllMeeting">

        </table>
    </div>
    <div>
        <img id="image" src="">
    </div>
<script src="js/commons.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>
