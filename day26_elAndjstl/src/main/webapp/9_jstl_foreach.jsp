<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
普通for循环:
<c:forEach begin="从哪里开始" end="到哪里结束" step="遍历的步长" var="变量名,用来存储遍历出来的值,默认存储到page域中">
     ${var属性的值}
</c:forEach>
--%>
<%--需求:输出1-10之间的数到页面上--%>
<c:forEach begin="1" end="10" step="1" var="i">
    <font color="red">${i}</font> <br/>
</c:forEach>


<%
    // 往域对象中存list集合
    ArrayList<String> list = new ArrayList<String>();
    list.add("itheima");
    list.add("java");
    list.add("itcast");
    request.setAttribute("list",list);
%>
<%--
增强for循环:
<c:forEach items="要遍历的集合---使用EL表达式去域对象中获取集合" var="变量名,用来存储遍历出来的值" varStatus="记录遍历过程的信息">
   ${var属性的值}
</c:forEach>
--%>
<c:forEach items="${list}" var="element">
    <font color="blue">${element}</font> <br/>
</c:forEach>

<c:forEach items="${list}" var="element" varStatus="status">
    <font color="blue">${element}</font>  <br/>
    当前遍历的索引: ${status.index}<br/>
    当前遍历的次数: ${status.count}<br/>
    是否是第一个元素: ${status.first}<br/>
    是否是最后一个元素: ${status.last}<br/>
    -----------------------------<br/>
</c:forEach>


</body>
</html>
