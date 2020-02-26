<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/student_css.css" rel="stylesheet" type="text/css"/>
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
        $("#rno").val(getCookie("sno"))
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
    function Student_Mission_Add_Info(){
      var sno=getCookie("sno");
      var province=$("#province").val();
      var city=$("#city").val();
      var company=$("#company").val();
      var linkman=$("#linkman").val();
      var linkmanphone=$("#linkmanphone").val();
      var STUDENT_MISSION_ADD_INFO="http://localhost:8080/student/student_mission_add_info/"+sno+"/"+
          province+"/"+city+"/"+company+"/"+linkman+"/"+linkmanphone;
      $.ajax({
        contentType: "application/json",
        url:STUDENT_MISSION_ADD_INFO,
        dataType: "text json",
        type:"post",
        statusCode:{
          200:function(data){
            alert("信息插入成功！")
            window.location="student_mission_index.jsp";
          },
          404:function(){
            alert("信息插入失败！");
            window.location="student_mission_registInfo.jsp";
          }
        }
      });
    }
</script>

<style>
  /*  .main .font_size{font-size: 18px;}*/
  .main input  {font-size: 10px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;line-height:50px;height:30px;width:150px;text-align: center}
  .main button  {background: #ddfff8;  /*设置输入框背景色*/font-size: 20px;border-radius:30px;margin: 10px auto;border:1px solid #1175c8;margin-top: 10px;width: 50px;}
  .main .ul .li{margin-top: 20px}
</style>

<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="student_index.jsp"><img src="../images/home.png" width="64" height="64" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="/student/student_index.jsp" ><img src="../images/icon02.png" title="1"/>
            <h2>个人信息</h2></a></li>
        <li><a href="/student/loadTask" class="selected"><img src="../images/icon03.png" title="2"/>
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
                <li><cite></cite><a href="/student/student_mission_index.jsp">查看任务</a><i></i></li>
                <li class="active"><cite></cite><a href="/student/student_mission_registInfo.jsp">登记实训信息 </a><i></i></li>
            </ul>
        </dd>
    </dl>

    <div class="main">
        <div style="width: 80%;overflow: hidden;margin: 0 auto;">
                <div style="margin-left:auto;margin-right:auto;margin-top:50px;background-color: #D2E9FF;width: 500px;height: 500px">
                    <div style="background-color: #C0E1FF;width: 500px;height: 80px;margin-top: 50px">
                        <h1 style="font-size: 24px;text-align: center;">信息登记</h1>
                    </div>
                    <ul style="margin-top: 20px;">
                        <li style=" margin-left: 25%;font-size: 15px;letter-spacing:23px">学号：<input type="text" id="rno"  readonly="readonly"  ><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:23px">省份：<input type="text" id="province" value="" placeholder="请输入省份" ><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:23px">市级：<input type="text" id="city" value="" placeholder="请输入所在城市"  ><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:23px">公司：<input type="text" id="company" value="" placeholder="请输入实习公司"  ><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px;letter-spacing:10px"> 联系人：<input type="text" id="linkman" value="" placeholder="请输入公司联系人"  style="margin-left:15px "><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px">联系人电话：<input type="text" id="linkmanphone" value="" placeholder="请确认公司联系人号码" style="margin-left:20px "><br></li>
                        <li  style=" margin-left: 25%;font-size: 15px"><button onclick="Student_Mission_Add_Info()">确认</button> <button type="reset" style="margin-left: 150px">清空</button></li>
                    </ul>
                </div>
        </div>
    </div>
</div>
</body>
</html>
