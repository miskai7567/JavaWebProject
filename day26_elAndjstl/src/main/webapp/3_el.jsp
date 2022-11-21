<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--注意一: 根据域对象中的键取值,如果取不到就返回空串,不是null--%>
------${username}----
<br/>

<%--注意二: ${} 先去page域对象中查找,如果没有再去request域对象中查找,如果还没有再去session域对象中查找,如果还没有再去application域对象中查找,如果还没有,返回空串--%>
<%
    //pageContext.setAttribute("ekey","e");
    //request.setAttribute("ekey","ee");
    //session.setAttribute("ekey","eee");
    application.setAttribute("ekey","eeee");
%>
${ekey}
<br/>

<%--注意三: 键是特殊字符,使用${键名}方式就不好使了,就得使用${xxxScope[键名]}--%>
<%--以后键名不要含有特殊字符,不就行了--%>
<%
    // 往域对象中存map集合
    HashMap<String,String> map = new HashMap<String, String>();
    map.put("a.k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    map.put("k4","v4");
    request.setAttribute("m",map);

    request.setAttribute("a.b.c.d","abcd");
%>
---${m.k2}---<br/>
---${m.a.k1}---取不到值<br/>
---${a.b.c.d}---取不到值<br/>
---${requestScope.m["a.k1"]}---<br/>
---${requestScope["a.b.c.d"]}---<br/>

</body>
</html>
