<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/11/9
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
<hr>
<table border="1" cellspacing="0" width="800">
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
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 0}">
                <td>禁用</td>
            </c:if>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <td>
                    <a href="findById?id=${brand.id}">修改</a>
                    <%--<a href="deleteByIdServlet?id=${brand.id}">删除</a>--%>
                    <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>