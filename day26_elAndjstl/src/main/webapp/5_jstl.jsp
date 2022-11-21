<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="true">
    <font color="red">if标签  true</font>
</c:if>

<c:if test="false">
    <font color="red">if标签  false</font>
</c:if>

<hr/>

<%
    // 往域对象中存list集合
    ArrayList<String> list = new ArrayList<String>();
    list.add("itheima");
    list.add("java");
    list.add("itcast");
    list.add("itcast");
    list.add("itcast");
    list.add("itcast");
    request.setAttribute("list",list);
%>

<table border="1">
    <tr>
        <c:forEach items="${list}" var="element">
            <td>${element}</td>
        </c:forEach>
    </tr>
</table>

</body>
</html>
