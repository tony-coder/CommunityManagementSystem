<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/8
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我们的大学社团</title>
    <link rel="stylesheet" href="<%=basePath%>css/index.css" type="text/css">
</head>
<body>
<div class="body">
    <jsp:include page="header.jsp"/>
    <!--轮播-->
    <div class="limit">
        <div class="content">
            <!--html处理-->
            <div class="slider" id="slider" e-fun="slider">
                <a href="#">
                    <img src="<%=basePath%>images/show_course/1.jpg"/></a>
                <a href="#">
                    <img src="<%=basePath%>images/show_course/2.jpg"/></a>
                <a href="#">
                    <img src="<%=basePath%>images/show_course/3.jpg"/></a>
                <a href="#">
                    <img src="<%=basePath%>images/show_course/4.jpg"/></a>
                <a href="#">
                    <img src="<%=basePath%>images/show_course/5.jpg"/></a>
            </div>
        </div>
    </div>
    <div id="clubs_h">
        <div class="decoration_block"></div>
        <div class="decoration_note">
            全部社团
        </div>
    </div>
    <div id="list">
        <div id="list_wrap">
            <ul id="club_list">
                <c:forEach var="club" items="${clubList}" varStatus="status">
                    <li>
                        <div class="club_item">
                            <a href="<%=basePath%>jsp/club.jsp?clubId=${club.id}">
                                <img width="230" height="165" align="center"
                                     src="images/clubs/${club.id}/thumbnail.jpg"></a>
                            <div class="club_name">|&nbsp${club.name} </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<!--js-->
<script type="text/javascript" src="<%=basePath%>js/index/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/simba.website.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/common.js"></script>
</body>
</html>