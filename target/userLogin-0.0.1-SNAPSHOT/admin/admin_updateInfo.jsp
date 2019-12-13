<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/updateInfo_form.css" rel="stylesheet" type="text/css">
    <<script type="text/javascript" src="../JS/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="../JS/jquery.cookie.js"></script>
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
          window.location="../index.jsp"
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
    $(function () {
        var ano=getCookie("ano");
        var ADMIN_INFO_URL="http://localhost:8080/admin/admin_Info/"+ano;
        $.ajax({
            contentType: "application/json",
            url:ADMIN_INFO_URL,
            dataType: "text json",
            type:"POST",
            statusCode:{
                200:function(data){
                    var str="";
                    $(data).each(function(i,value){
                        document.getElementById('ano').value=value.ano;
                        document.getElementById('name').value=value.name;
                        document.getElementById('phone').value=value.phone;
                        document.getElementById('qq').value=value.qq;
                    });
                },
                404:function(){
                    alert("登陆失败！");
                    window.location="index.jsp";
                }
            }

        });

    })
    function admin_Update_Info(){
        var ano=getCookie("ano");
        var name=$("#name").val();
        var phone=$("#phone").val();
        var qq=$("#qq").val();
        var ADMIN_UPDATE_INFO_URL="http://localhost:8080/admin/admin_Update_Info/"+ano+"/"+name+"/"+phone+"/"+qq;
        $.ajax({
            contentType: "application/json",
            url:ADMIN_UPDATE_INFO_URL,
            dataType: "text json",
            type:"POST",
            statusCode:{
                200:function(data){
                   alert("修改成功！")
                    window.location.href="admin_updateInfo.jsp";
                },
                404:function(){
                    alert("修改失败！");
                    window.location="admin_updateInfo.jsp";
                }
            }
        });
    }
</script>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="teacher_management/teacher_mana_index.jsp"><img src="../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="student_management/student_mana_index.jsp"><img src="../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="class_management/class_mana_index.jsp" ><img src="../../images/icon01.png" title="班级管理"/>
            <h2>班级管理</h2></a></li>
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
                <li><cite></cite><a href="admin_personalInfo.jsp">查看个人信息</a><i></i></li>
                <li><cite></cite><a href="admin_updateInfo.jsp">修改个人信息</a><i></i></li>
                <li><cite></cite><a href="admin_updatePsd.jsp">修改个人密码</a><i></i></li>
                <li><cite></cite><a href="bulkInsert.jsp">导入人员信息</a><i></i></li>
                <li><cite></cite><a href="summary_graph.jsp">实习信息统计图</a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div class="form_wrap">
            <form class="form_info" >
                <div class="each_line"><span class="info_title">账号：</span><input style="margin-top: 8px;" class="input_info" type="text" id="ano" readonly="readonly"></div>
                <div class="each_line"><span class="info_title">姓名：</span><input class="input_info" type="text" id="name" ></div>
                <div class="each_line"><span class="info_title">电话：</span><input class="input_info" type="text" id="phone" ></div>
                <div class="each_line"><span class="info_title">QQ：&nbsp;</span><input class="input_info" type="text" id="qq" ></div>
                <div  class="confirm_button_wrap">
                    <input style="margin-left: -100px;" class="confirm_button" type="button" onclick="javascript:history.back(-1)" value="返回">
                     <input class="confirm_button" type="button" onclick=admin_Update_Info() value="确认">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>