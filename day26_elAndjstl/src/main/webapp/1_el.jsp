<%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
EL表达式:获取域对象中存储的值----简单数据类型(基本类型和字符串)
格式一: ${xxxScope.属性名}
格式二: ${属性名}
--%>

<%
    // jsp中有9个内置对象,域对象有4个,分别是: pageContext,request,session,application
    pageContext.setAttribute("akey","aaa");
    request.setAttribute("bkey","bbb");
    session.setAttribute("ckey","ccc");
    application.setAttribute("dkey","ddd");

    //pageContext.setAttribute("ekey","e");
    //request.setAttribute("ekey","ee");
    //session.setAttribute("ekey","eee");
    application.setAttribute("ekey","eeee");
%>

<h1>获取域对象中存储的值:jsp方式</h1>
<%= pageContext.getAttribute("akey") %>
<%= request.getAttribute("bkey") %>
<%= session.getAttribute("ckey") %>
<%= application.getAttribute("dkey") %>
<br/>

<h1>获取域对象中存储的值:EL方式--${xxxScope.属性名}</h1>
<%--EL表达式中有11个内置对象,用来获取域对象中值的对象分别是: pageScope,requestScope,sessionScope,applicationScope--%>
${pageScope.akey}
${requestScope.bkey}
${sessionScope.ckey}
${applicationScope.dkey}
<br/>
<h1>获取域对象中存储的值:EL方式--${属性名}</h1>
<%--简写方式:先去page域对象中查找,如果没有再去request域对象中查找,如果还没有再去session域对象中查找,如果还没有再去application域对象中查找,如果还没有,返回空串--%>
${akey}
${bkey}
${ckey}
${dkey}
${ekey}
<br/>

</body>
</html>
