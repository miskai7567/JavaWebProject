<%--
  Created by IntelliJ IDEA.
  User: 91275
  Date: 2022/11/11
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    
    <script>
        function goToAddBrandJsp() {
            // 跳转到addBrand.jsp页面
            location.href = "addBrand.jsp";
        }
    </script>
</head>
<body>
<input type="button" value="新增" onclick="goToAddBrandJsp()"><br>

<table>
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="brand">
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <c:if test="${brand.}"

        </tr>
    </c:forEach>
</table>
</body>
</html>
