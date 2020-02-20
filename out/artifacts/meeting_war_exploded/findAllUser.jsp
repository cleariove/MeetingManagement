<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/30
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="css/common.css"/>
</head>
<body onload="findAllUser()">
<jsp:include page="top.jsp"/>
<div class="leftMenu">
    <jsp:include page="leftMenu.jsp"/>
</div>
<div class="content">
    <table id="allUser" border="1px solid">

    </table>
</div>

<script src="js/commons.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>
