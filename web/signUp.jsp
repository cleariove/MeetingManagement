<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/8
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工注册</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commons.js"></script>
</head>
<body>
<div class="content">
        <fieldset>
            <legend>员工注册</legend>
            <table class="apply">
                <tr>
                    <td>姓名:</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>用户名:</td>
                    <td><input type="text" name="nickname"></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" id="psd" name="password" placeholder="密码至少6位数"></td>
                </tr>
                <tr>
                    <td>确认密码:</td>
                    <td>
                        <input type="password" id="confirm" onkeyup="confirmPassword()">
                        <span id="confirmSpan" ></span>
                    </td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <input type="radio" name="gender" value="男"><label>男</label>
                        <input type="radio" name="gender" value="女"><label>女</label>
                    </td>
                </tr>
                <tr>
                    <td>电话:</td>
                    <td><input type="text" name="tel"></td>
                </tr>
                <tr>
                    <td>工作:</td>
                    <td><input type="text" name="job"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="注册" onclick="signUp()"></td>
                </tr>
            </table>
        </fieldset>
</div>

</body>
</html>
