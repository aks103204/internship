<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../../JS/jquery.cookie.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        //顶部导航切换
        $(".nav li a").click(function () {
            $(".nav li a.selected").removeClass("selected");
            $(this).addClass("selected");
        })
      if(getCookie("ano")==null){
        alert("请先登陆后访问此网页！");
        window.location="../../index.jsp"
      }else{
        $("#span1").html(getCookie("ano"));
      }
    })
</script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active");
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
      delCookie("ano");
    }
    function teacher_Add_Info(){
      var tno=$("#tno").val();
      var password=$("#password").val();
      var name=$("#name").val();
      var phone=$("#phone").val();
      var profession=$("#profession").val();
      var qq=$("#qq").val();
      var TEACHER_INFO_ADD_URL="http://localhost:8080/admin/teacher_Add_Info/"+tno+"/"+password+"/"+name+"/"+phone+"/"+profession+"/"+qq;
      $.ajax({
        contentType: "application/json",
        url:TEACHER_INFO_ADD_URL,
        dataType: "text json",
        type:"post",
        statusCode:{
          200:function(data){
            alert("信息插入成功！")
            window.location="teacher_mana_index.jsp";
          },
          404:function(){
            alert("信息插入失败！");
            window.location="teacher_add.jsp";
          }
        }
      });
    }
</script>
<style>
    .per-input{
        margin-left:5%;height: 100%; overflow: hidden;float: left;margin-bottom: 8px;border: 1px #aaa solid;border-radius: 4px;background: 0 0;text-align: left;font-size: 20px;width: 438px;height: 50px;line-height: 2.4;padding: 0 20px;
    }
    .per-text{
        float:left;width: 80px;height: 30px;padding-top: 20px;font-size: 20px;
    }
</style>
<body style="background:url(../../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="../teacher_management/teacher_mana_index.jsp" class="selected"><img src="../../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="../student_management/student_mana_index.jsp"><img src="../../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="../class_management/class_mana_index.jsp"><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><img src="../../images/help.png" title="帮助" class="helpimg"/></span><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="../../index.jsp" onclick="quit()">退出</a></li>
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
                <span><img src="../../images/leftico01.png"/></span>管理信息
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="teacher_mana_index.jsp">教师管理首页</a><i></i></li>
                <li class="active"><cite></cite><a href="teacher_add.jsp">添加教师信息</a><i></i></li>

            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="width: 50%;overflow: hidden;margin: 0 auto;">
            <div style="font-size:30px;color: #000;text-align: center;padding-top: 20px;">添加教师信息</div>
            <div style="color: #000;text-align: center;padding-top: 20px;">
                <form >
                    <div style="width:130%;float: left;">
                        <div class="per-text">i d :</div>
                        <div><input class="per-input" type="text" id="tno" ></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">password:</div>
                        <div><input class="per-input" type="text" id="password"></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">name:</div>
                        <div> <input class="per-input" type="text" id="name" ></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">phone:</div>
                        <div> <input class="per-input" type="text" id="phone" ></div>
                    </div>

                    <div style="width:130%;float: left;">
                        <div class="per-text">profession:</div>
                        <div> <input class="per-input" type="text" id="profession" ></div>
                    </div>
                    <div style="width:130%;float: left;">
                        <div class="per-text"> Q Q :</div>
                        <div><input class="per-input" type="text" id="qq" ><br></div>
                    </div>
                    <div style="padding-left: 50%;width:60%;float: left;font-size: 20px;">
                        <a style="font-size: 20px; background: #fff;" href="javascript:void(0)" onclick="teacher_Add_Info()">添加</a>
                    </div>
                </form>
            </div>
        </div>

   </div>
</div>
</body>
</html>
