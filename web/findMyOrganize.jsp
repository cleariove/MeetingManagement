<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/12/9
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/common.css"/>
</head>
<body onload="findMyOrganize()">
<jsp:include page="top.jsp"/>
<div class="leftMenu">
    <jsp:include page="leftMenu.jsp"/>
</div>
<div class="content">
    <table  border="1 solid" id="findMyOrganize">

    </table>
</div>
<script src="js/commons.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>
