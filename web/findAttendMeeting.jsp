<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/12/2
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参与的会议</title>
    <link rel="stylesheet" href="css/common.css"/>
</head>
<body onload="findAttendingMeeting()">
<jsp:include page="top.jsp"/>
<div class="leftMenu">
    <jsp:include page="leftMenu.jsp"/>
</div>
<div class="content">
    <table  id="findAttendingMeeting" border="1 solid">

    </table>
</div>
<script src="js/commons.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>
