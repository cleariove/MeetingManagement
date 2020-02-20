<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/8
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录会议系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>
  <body>
  <div class="modal-title">
    <h1 class="text-center">登录</h1>
  </div>
  <div class="modal-body">
    <div class="form-group">
      <label>用户名</label>
        <input name="account" class="form-control" type="text" placeholder="请输入用户名">
    </div>
    <div class="form-group">
      <label>密码</label>
      <input name="password" class="form-control" type="password" placeholder="请输入密码">
    </div>
    <span id="tipSpan"></span>
  </div>

  <div class="text-right">
    <button class="btn btn-primary" onclick="logIn()">登录</button>
    <button class="btn btn-danger" data-dismiss="modal"><a href="signUp.jsp">注册</a></button>

  </div>

  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/commons.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
