<%@ page import="com.itheima.bean.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int num = 10;
    request.setAttribute("num", num);
%>
${num + 10} <br/>
${num - 10} <br/>
${num * 10} <br/>
${num / 10} <br/>
${num % 10} <br/>
${num > 10} <br/>
${num < 10} <br/>
${num == 10} <br/>

<h1>EL表达式运算和java不同的地方:</h1>
<%--1.基本类型和字符串不能相加运算(不能拼接字符串),但如果字符串的内容是数字,它会自动转换为数字,发生数学运算,否则会报异常--%>
${num + "10"} <br/>
${num + "10.2"} <br/>
<%--${num + "a"}  报错  --%>

<%--2.除法运算会保留小数--%>
${10 / 3} <br/>

<%--3.空判断: 对象为null是空,集合的长度为0也是空,字符串长度为0也是空--%>

<%
    User user = null;
    User user2 = new User();
    request.setAttribute("u1", user);
    request.setAttribute("u2", user2);
%>
是否为空: ${empty u1} --- 是否不为空: ${not empty u1}<br/>
是否为空: ${empty u2} --- 是否不为空: ${not empty u2}<br/>

<%
    ArrayList<String> list1 = null;
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();
    list3.add("aaa");
    request.setAttribute("list1", list1);
    request.setAttribute("list2", list2);
    request.setAttribute("list3", list3);
%>
是否为空: ${empty list1} <br/>
是否为空: ${empty list2} <br/>
是否为空: ${empty list3} <br/>

<%
    String s1 = null;
    String s2 = "";
    String s3 = "a";

    request.setAttribute("s1", s1);
    request.setAttribute("s2", s2);
    request.setAttribute("s3", s3);
%>
是否为空: ${empty s1} <br/>
是否为空: ${empty s2} <br/>
是否为空: ${empty s3} <br/>

</body>
</html>
