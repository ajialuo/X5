<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath();
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
request.getSession().setAttribute("user", request.getAttribute("user"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/scripts/jquery/jquery-1.8.3.js"/>"></script>
<script type="text/javascript">
function findAllInfos(){
	window.location.href='<%=path%>/getUserList'
}
</script>
<title>用户列表</title>
</head>
<body>
 <table border="1">
 <tr>
     <td>id</td>
     <td>name</td>
     <td>pwd</td>
 </tr>
 
 <tr>
     <td>${user.id}</td>
     <td>${user.name}</td>
     <td>${user.pwd}</td>
 </tr>
 </table>
 <input type="button" onclick="findAllInfos()" value="获取所有用户信息"></input>
</body>
</html>