<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎使用专业实习实训管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="JS/jquery.js"></script>
    <script src="JS/cloud.js" type="text/javascript"></script>
</head>
<% request.getSession().invalidate();
    System.out.println("******!*****"+request.getSession().getAttribute("user"));%>
<script language="javascript">
    $(function () {
        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        $(window).resize(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 471) / 2});
        })
    });
</script>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>

<div class="logintop">
    <span>欢迎使用专业实习实训管理系统</span>
    <ul>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox">
        <form action="./login" method="post">
            <ul>
                <li><input name="id" type="text" class="loginuser" placeholder="学号/工号"/></li>
                <li><input name="password" type="password" class="loginpwd" placeholder="密码"/></li>
                <li>
                    <select name="identity" class="loginselect">
                        <option value="admin">管理员</option>
                        <option value="teacher">教师</option>
                        <option value="student">学生</option>
                    </select>
                </li>
                <li>
                    <input type="submit" class="loginbtn" value="登录"/>
                </li>
                <li>
                    <%
                        String loginmsg = (String) request.getAttribute("loginmsg");
                        if (loginmsg!=null) {%>
                            <label style="color: #ff0000"><%=loginmsg%></label>
                    <%}%>
                </li>
            </ul>
        </form>
    </div>
</div>

<div class="loginbm">学习使用</div>

</body>
</html>
