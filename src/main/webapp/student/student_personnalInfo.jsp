<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../JS/jquery.cookie.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        //顶部导航切换
        $(".nav li a").click(function () {
            $(".nav li a.selected").removeClass("selected")
            $(this).addClass("selected");
        })
      if(getCookie("sno")==null){
        alert("请先登陆后访问此网页！");
        window.location="../index.jsp"
      }else{
        $("#span1").html(getCookie("sno"));
      }
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active")
            $(this).addClass("active");
        });

        $('.title').click(function () {
            var $ul = $(this).next('ul');
            $('dd').find('ul').slideUp();
            if ($ul.is(':visible')) {
                $(this).next('ul').slideUp();
            } else {
                $(this).next('ul').slideDown();
            }
        });
    })
      var getCookie = function (name) {
        //获取当前所有cookie
        var strCookies = document.cookie;
        //截取变成cookie数组
        var array = strCookies.split(';');
        //循环每个cookie
        for (var i = 0; i < array.length; i++) {
          //将cookie截取成两部分
          var item = array[i].split("=");
          //判断cookie的name 是否相等
          if (item[0] == name) {
            return item[1];
          }
        }
        return null;
      }
      var delCookie = function (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        //获取cookie是否存在
        var value = getCookie(name);
        if (value != null) {
          document.cookie = name + "=" + escape("") + ";expires="+ exp.toUTCString()+ ";path=/";
        }
      }
      function quit() {
        delCookie("sno");
      }
    $(function () {
      var sno=getCookie("sno");
      var STUDENT_INFO_URL="http://localhost:8080/student/student_Info/"+sno;
      $.ajax({
        contentType: "application/json",
        url:STUDENT_INFO_URL,
        dataType: "text json",
        type:"post",
        statusCode:{
          200:function(data){
            var str="";
            $(data).each(function(i,value){
              str+="<tr><td style=\"margin-left:30%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;\">"+"用户账户（学号）："+value.sno+"</td>"+
                  "<td style=\"margin-left:30%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;\">"+"姓名："+value.sname+"</td>"+
                  "<td style=\"margin-left:30%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;\">"+"联系方式："+value.sphone+"</td>"+
                  "<td style=\"margin-left:30%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;\">"+"QQ："+value.qq+"</td></tr>";
            });
            $("#msg").append(str);
          },
          404:function(){
            alert("登陆失败！");
            window.location="index.jsp";
          }
        }
      });
    });
</script>

<style>
    .main ul {margin-top: 20px;}
    .main ul li{font-size: 15px; margin-top: 10px; margin-left: 400px;}
    .main ul li a {font-size: 15px; margin-left: 10px;text-decoration: none;}
    .main ul hr{  height:1px;border:none;border-top:1px solid #555555; margin-top: 10px;width: 80%;margin-left: 230px;position: absolute;}
</style>


<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="student_index.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/student_index.jsp" class="selected"><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/student_mission_index.jsp"><img src="../images/icon03.png" title="2"/>
            <h2>任务模块</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../index.jsp" onclick="quit()">退出</a></li>
        </ul>
        <div class="user">
            <span id="span1"></span>
        </div>
    </div>
</div>

<div class="container">
    <div class="lefttop"><span></span>列表</div>

    <dl class="leftmenu">
        <dd>
            <div class="title">
                <span><img src="../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li class="active"><cite></cite><a href="/student/student_personnalInfo.jsp">查找信息</a><i></i></li>
                <li><cite></cite><a href="student_updatePsd.jsp">修改密码</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main"id="msg">
    </div>
</div>
</body>
</html>
