<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/other.css" rel="stylesheet" type="text/css"/>
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

        $("#submit1").click(function(){

            var type = $("input[name=type]:checked").val();
            var file = document.getElementById("file").files[0];
            if (file == null) {
                alert("请选择您需要上传的文件！");
            }
            var fileform = new FormData();
            fileform.append("file", file);
            fileform.append("type", type);
            var ADMIN_INSERT_INFO_URL="http://localhost:8080/admin/admin_Insert_Info/";
            $.ajax({
                contentType: "application/json",
                url :ADMIN_INSERT_INFO_URL ,
                dataType: "text json",
                type : "POST",
                data : fileform,
                processData: false,//用于对data参数进行序列化处理 这里必须false
                contentType: false, //必须
                statusCode:{
                200 : function(data) {
                    alert("文件上传成功，信息已经插入！")
                    window.location="bulkInsert.jsp";
                },
                404:function(){
                    alert(data.value);
                    window.location="bulkInsert.jsp";
                    }
                }
            });
        });
    })

    function showfile() {
        var obj=document.getElementById("file");
        var len=obj.files.length;
        var fileName="";
        for (var i=0;i<len;i++){
            var filePath=obj.files[i].name;
            var temp=filePath.substring(filePath.lastIndexOf("\\")+1);
            if(i==0){
                fileName=temp;
            }else{
                fileName=fileName+","+temp;
            }
        }
        document.getElementById("peopleFiletext").value=fileName;

    }
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
</script>
<body style="background:url(../images/topbg.gif) repeat-x;">
<div class="top">
    <div class="topleft">
        <a href="/admin/admin_index.jsp"><img src="../images/home.png" style="width: 64px;height: 64px" title="系统首页"/></a>
    </div>

    <ul class="nav">
        <li><a href="teacher_management/teacher_mana_index.jsp" class="selected"><img src="../images/icon02.png" title="教师管理"/>
            <h2>教师管理</h2></a></li>
        <li><a href="student_management/student_mana_index.jsp"><img src="../images/icon03.png" title="学生管理"/>
            <h2>学生管理</h2></a></li>
        <li><a href="class_management/class_mana_index.jsp" ><img src="../images/icon01.png" title="班级管理"/>
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
        <form id="uploadfile"class="fileUpload" enctype="multipart/form-data">
            <p>
                <input type="text" id="peopleFiletext" class="peopleFiletext" disabled>
                <input type="file" id="file" name="file" class="peopleInfoUpload" value="选择文件(支持xls,xlsx)" accept=".xls,.xlsx" onchange="showfile()"/>
            </p>
            <p>
                <input type="radio" name="type" id="teacher" value="teacher" checked/>
                <label class="radio-text">教师</label>
                <input type="radio" name="type" id="student" value="student"/>
                <label class="radio-text">学生</label>
            </p>
            <p>
                <input type="button" class="fileButton" value="提交" id="submit1"/>
                <input type="reset" class="fileButton" value="重置" id="reset"/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
