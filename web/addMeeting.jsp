<%--
  Created by IntelliJ IDEA.
  User: me
  Date: 2019/11/30
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议申请</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="leftMenu">
    <jsp:include page="leftMenu.jsp"/>
</div>
<div class="content">
        <fieldset>
            <legend>会议申请</legend>
            <table class="apply">
                <tr>
                    <td>会议名称:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>会议时间:</td>
                    <td><input type="date" name="date" style="width: 160px"></td>
                </tr>
                <tr>
                    <td>会议地点:</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>会议内容:</td>
                    <td><input type="text" name="content"></td>
                </tr>
                <tr>
                    <td>住宿:</td>
                    <td><input type="text" name="accommodation"></td>
                </tr>
                <tr>
                    <td>需要姓名:</td>
                    <td>
                        <input type="radio" name="needName" value="true"><label>是</label>
                        <input type="radio" name="needName" value="false"><label>否</label>
                    </td>
                </tr>
                <tr>
                    <td>需要电话:</td>
                    <td>
                        <input type="radio" name="needTel" value="true"><label>是</label>
                        <input type="radio" name="needTel" value="false"><label>否</label>
                    </td>
                </tr>
                <tr>
                    <td>需要工作:</td>
                    <td>
                        <input type="radio" name="needJob" value="true"><label>是</label>
                        <input type="radio" name="needJob" value="false"><label>否</label>
                    </td>
                </tr>
                <tr>
                    <td>需要性别:</td>
                    <td>
                        <input type="radio" name="needGender" value="true"><label>是</label>
                        <input type="radio" name="needGender" value="false"><label>否</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="提交" onclick="addMeeting()"></td>
                </tr>
            </table>
        </fieldset>
</div>
<script src="js/commons.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>
