<%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int num = 10;
    request.setAttribute("num",num);
%>

<%--
<c:if> 相当于java里面if判断
<c:if> 标签里面的test属性,就是判断条件,值可以写EL表达式
<c:if> 标签里面的var属性,用来存储test属性的值,值不可以写EL表达式,var属性的值默认是存储到page域中
<c:if> 标签里面的scope属性,用来指定var属性的值保存到哪个域中
--%>
<%--需求:判断域对象中num的值,如果num大于10,就显示num大于10,如果num小于10,就显示num小于10,如果num等于10,就显示num等于10--%>
<c:if test="${num == 10}">
    num 等于 10
</c:if>
<c:if test="${num > 10}">
    num 大于 10
</c:if>
<c:if test="${num < 10}">
    num 小于 10
</c:if>

<hr/>

<%--默认是page域--%>
<c:if test="${num == 10}" var="res" scope="session">
    num 等于 10 <br/>
</c:if>

<%--${res} 去域对象中获取res键的值--%>
<c:if test="${res}">
    num 等于 10 <br/>
</c:if>

</body>
</html>
