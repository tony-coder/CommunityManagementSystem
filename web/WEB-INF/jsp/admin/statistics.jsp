<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/22
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>社团课程报名管理系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header"><a class="app-header__logo" href="<%=basePath%>admin/index.do">后台管理系统</a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i
                class="fa fa-user fa-lg"></i></a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="<%=basePath%>student/account"><i class="fa fa-cog fa-lg"></i>
                    账号设置</a></li>
                <%--                <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>--%>
                <li><a class="dropdown-item" href="<%=basePath%>quit.do"><i class="fa fa-sign-out fa-lg"></i> 退出</a>
                </li>
            </ul>
        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar"
                                        src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name">${admin.id}</p>
            <p class="app-sidebar__user-designation">管理员</p>
        </div>
    </div>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="<%=basePath%>admin/index.do"><i class="app-menu__icon fa fa-user"></i><span
                class="app-menu__label">欢迎</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/club.do"><i
                class="app-menu__icon fa fa fa-book"></i><span class="app-menu__label">社团管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/student.do"><i
                class="app-menu__icon fa fa-align-left"></i><span
                class="app-menu__label">学生管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/course.do"><i class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">社团课程管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/StuCourse.do"><i
                class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">选课管理</span></a></li>

        <li><a class="app-menu__item" href="<%=basePath%>admin/clubStatistics.do"><i
                class="app-menu__icon fa fa-edit"></i><span
                class="app-menu__label">统计图表</span></a></li>
    </ul>
</aside>
<%--content--%>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1><i class="fa fa-pie-chart"></i> 社团报名统计图表</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
            <li class="breadcrumb-item"><a href="<%=basePath%>admin/clubStatistics.do">统计图表</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <form class="form-group col-md-12" id="updateCourseForm"
                      action="<%=basePath%>/admin/clubStatistics.do">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-3">
                                <label>学期</label>
                                <select class="form-control" name="selectTerm" required>
                                    <option disabled selected>请选择学期</option>
                                    <option>2018-2019(1)</option>
                                    <option>2018-2019(2)</option>
                                    <option>2019-2020(1)</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="tile-footer">
                        <button class="btn btn-primary" type="submit">查询</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">

        <div class="col-md-6">
            <div class="tile">
                <h3 class="tile-title">Bar Chart</h3>
                <div class="embed-responsive embed-responsive-16by9">
                    <canvas class="embed-responsive-item" id="barChartDemo"></canvas>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="tile">
                <h3 class="tile-title">Pie Chart</h3>
                <div class="embed-responsive embed-responsive-16by9">
                    <canvas class="embed-responsive-item" id="pieChartDemo"></canvas>
                </div>
            </div>
        </div>

    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>js/popper.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="<%=basePath%>js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="<%=basePath%>js/plugins/chart.js"></script>
<script type="text/javascript">
    var Labels = " <%=(ArrayList<String>)request.getAttribute("clubStatisticsLabels")%>";
    var Values = " <%=(ArrayList<Integer>)request.getAttribute("clubStatisticsValue")%>";
    var labels = [];
    var values = [];

    function getLabels() {
        var s = '';
        for (var i = 0; i < Labels.length; i++) {
            if (Labels[i] === '[' || Labels[i] === ' ') ;
            else if (Labels[i] === ']') {
                labels.push(s);
                break;
            } else if (Labels[i] === ',') {
                labels.push(s);
                s = '';
            } else {
                s += Labels[i];
            }
        }
    }

    function getValues() {
        var s = '';
        for (var i = 0; i < Values.length; i++) {
            if (Values[i] === '[' || Values[i] === ' ') ;
            else if (Values[i] === ']') {
                values.push(s);
                break;
            } else if (Values[i] === ',') {
                values.push(s);
                s = '';
            } else {
                s += Values[i];
            }
        }
    }

    getLabels();
    getValues();

    var data = {
        labels: labels,
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: values
            }

        ]
    };
    var pdata = [
        {
            value: 300,
            color: "#F7464A",
            highlight: "#FF5A5E",
            label: "Red"
        },
        {
            value: 50,
            color: "#46BFBD",
            highlight: "#5AD3D1",
            label: "Green"
        },
        {
            value: 100,
            color: "#FDB45C",
            highlight: "#FFC870",
            label: "Yellow"
        }
    ]

    // var ctxl = $("#lineChartDemo").get(0).getContext("2d");
    // var lineChart = new Chart(ctxl).Line(data);

    var ctxb = $("#barChartDemo").get(0).getContext("2d");
    var barChart = new Chart(ctxb).Bar(data);

    // var ctxr = $("#radarChartDemo").get(0).getContext("2d");
    // var radarChart = new Chart(ctxr).Radar(data);

    // var ctxpo = $("#polarChartDemo").get(0).getContext("2d");
    // var polarChart = new Chart(ctxpo).PolarArea(pdata);

    var ctxp = $("#pieChartDemo").get(0).getContext("2d");
    var pieChart = new Chart(ctxp).Pie(pdata);

    // var ctxd = $("#doughnutChartDemo").get(0).getContext("2d");
    // var doughnutChart = new Chart(ctxd).Doughnut(pdata);
</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if (document.location.hostname == 'pratikborsadiya.in') {
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>

</body>
</html>
