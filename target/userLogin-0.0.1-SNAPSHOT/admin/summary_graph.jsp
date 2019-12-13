<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎！</title>
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
        <li><a href="class_management/class_mana_index.jsp"><img src="../images/icon01.png" title="班级管理"/>
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

    <%--内容模块--%>
    <div class="main">

        <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
        <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->

        <div id="mainMap" style="height:700px;width: 1200px;padding:10px;background:#1B1B1B;margin: 0 auto;">
        </div>
        <!--Step:2 引入echarts.js-->

        <script type="text/javascript" src="../JS/jquery-1.8.0.js"></script>
        <script src="../JS/echarts.js" charset="UTF-8"></script>
        <script src="../JS/highcharts.js" charset="UTF-8"></script>

        <script type="text/javascript">
            $(function(){
                getEcharts();
            });
        </script>

        <script type="text/javascript">
            function getEcharts() {
                var chart = null;
// 获取 CSV 数据并初始化图表
                $.getJSON('https://data.jianshukeji.com/jsonp?filename=csv/analytics.csv&callback=?', function (csv) {
                    chart = Highcharts.chart('container', {
                        data: {
                            csv: csv
                        },
                        title: {
                            text: '某网站日常访问量'
                        },
                        subtitle: {
                            text: '数据来源: Google Analytics'
                        },
                        xAxis: {
                            tickInterval: 7 * 24 * 3600 * 1000, // 坐标轴刻度间隔为一星期
                            tickWidth: 0,
                            gridLineWidth: 1,
                            labels: {
                                align: 'left',
                                x: 3,
                                y: -3
                            },
                            // 时间格式化字符
                            // 默认会根据当前的刻度间隔取对应的值，即当刻度间隔为一周时，取 week 值
                            dateTimeLabelFormats: {
                                week: '%Y-%m-%d'
                            }
                        },
                        yAxis: [{ // 第一个 Y 轴，放置在左边（默认在坐标）
                            title: {
                                text: null
                            },
                            labels: {
                                align: 'left',
                                x: 3,
                                y: 16,
                                format: '{value:.,0f}'
                            },
                            showFirstLabel: false
                        }, {    // 第二个坐标轴，放置在右边
                            linkedTo: 0,
                            gridLineWidth: 0,
                            opposite: true,  // 通过此参数设置坐标轴显示在对立面
                            title: {
                                text: null
                            },
                            labels: {
                                align: 'right',
                                x: -3,
                                y: 16,
                                format: '{value:.,0f}'
                            },
                            showFirstLabel: false
                        }],
                        legend: {
                            align: 'left',
                            verticalAlign: 'top',
                            y: 20,
                            floating: true,
                            borderWidth: 0
                        },
                        tooltip: {
                            shared: true,
                            crosshairs: true,
                            // 时间格式化字符
                            // 默认会根据当前的数据点间隔取对应的值
                            // 当前图表中数据点间隔为 1天，所以配置 day 值即可
                            dateTimeLabelFormats: {
                                day: '%Y-%m-%d'
                            }
                        },
                        plotOptions: {
                            series: {
                                cursor: 'pointer',
                                point: {
                                    events: {
                                        // 数据点点击事件
                                        // 其中 e 变量为事件对象，this 为当前数据点对象
                                        click: function (e) {
                                            $('.message').html( Highcharts.dateFormat('%Y-%m-%d', this.x) + ':<br/>  访问量：' +this.y );
                                        }
                                    }
                                },
                                marker: {
                                    lineWidth: 1
                                }
                            }
                        }
                    });
                });

            }
        </script>
    </div>

</div>
</body>
</html>

