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

<%--${res} 去域对象中获取res键的值--%>
<c:if test="${res}">
    num 等于 10 <br/>
</c:if>

</body>
</html>
