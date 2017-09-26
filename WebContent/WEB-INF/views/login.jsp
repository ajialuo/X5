<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
<div>
<div id="">
    <form action="login" method="post">
	    <span>用户名：</span><input type="text" name="name"></input><br/>
	    <span>密码：</span><input type="password" name="pwd"></input>
	    <input type="submit" value="登录"/>
    </form>
</div>
</div>
</body>
</html>