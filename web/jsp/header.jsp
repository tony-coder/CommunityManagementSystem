<%@ page import="cn.zjut.bean.Admin" %>
<%@ page import="cn.zjut.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  //获取web应用根目录路径
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<style>
    .top_wrap {
        width: 1000px;
        height: 60px;
        margin: 0 auto;
        posiiton: relative;
        float: left;
    }

    .top {
        width: 1000px;
        height: 60px;
        margin: 0 auto;
        posiiton: relative;
    }

    .top_option {
        float: left;
        font-size: 20px;
        width: 150px;
        height: 60px;
        line-height: 60px;
        text-align: center;
        overflow: hidden;
        margin-bottom: 10px;
    }

    .top_option:hover {
        background: #333;
        color: #fff;
    }

    .option_wrap a {
        text-decoration: none;
        color: #666;
        font-family: 微软雅黑;
    }

    .option_wrap {
        position: relative;
        float: left;
    }

    #logo {
        float: left;
    }
</style>
<div class="top">
    <div class="top_wrap">
        <div id="logo" }>
            <a href="<%=basePath%>index.jsp"><img width="298" height="60" alt="logo"
                                                  src="<%=basePath%>images/logo.jpg"></a>
        </div>
        <div class="option_wrap">
            <a href="<%=basePath%>index.jsp">
                <div class="top_option">全部社团</div>
            </a>
            <%--            <a href="<%=basePath%>jsp/login.jsp">--%>
            <%--                <div class="top_option">我的社团</div>--%>
            <%--            </a>--%>
            <%!
                String status;
                String method;
                private String userMethod;
            %>
            <%
                if (request.getSession().getAttribute("user") == null) {
                    status = "登录";
                    method = "jsp/login.jsp";
                    userMethod = "#";
                } else {
                    status = "登出";
                    if (((String) request.getSession().getAttribute("type")).equals("admin")) {
                        //status = ((Admin) request.getSession().getAttribute("user")).getName();
                        userMethod = "admin/index.do";
                    } else {
                        //status = ((Student) request.getSession().getAttribute("user")).getName();
                        userMethod = "student/studentStatus.do";
                    }
                    method = "quit.do";
                }
            %>
            <a href="<%=basePath%>jsp/mycourse.jsp">
                <div class="top_option">我的课程</div>
            </a>
            <a href="<%=basePath%><%=method%>">
                <div class="top_option"><%=status%>
                </div>
            </a>
            <a href="<%=basePath%><%=userMethod%>">
                <div class="top_option">
                    ${user.getName()}
                </div>
            </a>
        </div>
    </div>
</div>
</body>
</html>