<%@ page import="com.itheima.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: pzl
  Date: 2022/11/11
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>获取javabean</h1>
<%
    // 往域对象中存储user对象
    User user = new User("zs","123456");
    request.setAttribute("u",user);
%>

<%--获取域对象中user的属性值: ${键名.javaBean对象的属性名}--%>
${u.getUsername()}-----${u.getPassword()}<br/>
${u.username}-----${u.password}<br/>


<h1>获取数组: ${键名[索引]}</h1>
<%
    // 往域对象中存数组
    String[] arr = {"itheima","itcast","java"};
    request.setAttribute("array",arr);
%>

${array[0]}
${array[1]}
${array[2]}
<br/>

<h1>获取list集合: ${键名[索引]}  ----  ${键名.get(索引)}</h1>
<%
    // 往域对象中存list集合
    ArrayList<String> list = new ArrayList<String>();
    list.add("itheima");
    list.add("java");
    list.add("itcast");
    request.setAttribute("list",list);
%>

${list[0]} --- ${list.get(0)}<br/>
${list[1]} --- ${list.get(1)}<br/>
${list[2]} --- ${list.get(2)}<br/>
<br/>

<h1>获取map集合: ${键名.map集合中的键名}  ----  ${键名.get(map集合中的键名)}</h1>
<%
    // 往域对象中存map集合
    HashMap<String,String> map = new HashMap<String, String>();
    map.put("k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    map.put("k4","v4");
    request.setAttribute("m",map);
%>
${m.k1} --- ${m.get("k1")} <br/>
${m.k2} --- ${m.get("k2")} <br/>
${m.k3} --- ${m.get("k3")} <br/>
${m.k4} --- ${m.get("k4")} <br/>

</body>
</html>
