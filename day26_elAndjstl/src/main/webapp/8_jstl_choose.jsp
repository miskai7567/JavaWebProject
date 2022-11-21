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
<c:choose>...<c:when>...<c:otherwise> 相当于java中的if...else if... else
test属性: 判断条件,支持EL表达式
--%>
<c:choose>
    <c:when test="${num > 10}">
        num 大于 10
    </c:when>
    <c:when test="${num < 10}">
        num 小于 10
    </c:when>
    <c:otherwise>
        num 等于10
    </c:otherwise>
</c:choose>

</body>
</html>
