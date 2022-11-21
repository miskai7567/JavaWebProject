<%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/10
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--html代码--%>
<h1>hello jsp...</h1>

<%--java代码--%>
<%
    System.out.println("Hello JSP...");
%>

<!--html注释-->
<%--jsp的注释--%>
<%--
<%...%>：内容会直接放到_jspService()方法之中
--%>
<%
    // _jspService方法中可以写什么内容,这里就可以写什么内容
    int num = 10;
    System.out.println("num = " + num);
    System.out.println("内容会直接放到_jspService方法中...");
%>

<%--<%=…%>：内容会放到out.print()中，作为out.print()的参数--%>
<%--print()方法的参数可以传什么,这里就可以写什么--%>
<%= 100 %>
<%= num %>

<%--<%!…%>：内容会放到_jspService()方法之外，被类直接包含--%>
<%!
    // xx_jsp.java文件的类中可以定义啥内容,这里就可以写啥内容
    String str = "jsp";
    public void method(){
        System.out.println("method方法...");
    }
%>

</body>
</html>
