<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath();
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
*{
    margin:0;
    padding:0;
}
ul,li{
    list-style: none;
    float:left; 
    margin-left:20px;
}
.active a{
    pointer-events:none;
    cursor:default;
    color:#000000
}
a {
    text-decoration:none
}
</style>
<script type="text/javascript" src="<c:url value="/scripts/jquery/jquery-1.8.3.js"/>"></script>
<script type="text/javascript">
    function queryDeviceRecords(pageNum){
   	   $.ajax({
	       type: "POST",
	       url: '<%=path%>/getUserList',
	       data: {"pageNum":pageNum},
	       async: false,
	       success: function(data) {
	    	   $("html").html("");
	    	   $("html").html(data);
	       },
	       error: function(request) {
	    	   showAlert('系统出错' + data);
	       }
	    }); 
}
</script>
<title>用户列表</title>
</head>
<body id="partcenter">
 <table border="1">
 <tr>
     <td>id</td>
     <td>name</td>
     <td>pwd</td>
 </tr>
 <c:forEach items="${userList }" var="user">
     <tr>
     <td>${user.id }</td>
     <td>${user.name }</td>
     <td>${user.pwd }</td>
    </tr>
 </c:forEach>
 </table>
 <!-- 分页 -->
 <div class="message">
       共<i class="blue">${pagehelper.total}</i>条记录，当前显示第&nbsp;<i
           class="blue">${pagehelper.pageNum}/${pagehelper.pages}</i>&nbsp;页
   </div>
   <div style="text-align:center;">
       <ul class="pagination">
           <c:if test="${pagehelper.isFirstPage == false}">
               <li><a href="javascript:queryDeviceRecords(${pagehelper.firstPage});">首页</a></li>
               <li><a href="javascript:queryDeviceRecords(${pagehelper.prePage});">上一页</a></li>
           </c:if>
           <c:forEach items="${pagehelper.navigatepageNums}" var="navigatepageNum">
           
               <c:if test="${navigatepageNum==pagehelper.pageNum}">
                   <li class="active"><a href="javascript:queryAllDevices(${navigatepageNum});">${navigatepageNum}</a></li>
               </c:if>
               <c:if test="${navigatepageNum!=pagehelper.pageNum}">
                   <li><a href="javascript:queryDeviceRecords(${navigatepageNum});">${navigatepageNum}</a></li>
               </c:if>
           </c:forEach>
           <c:if test="${!pagehelper.isLastPage}">
               <li><a href="javascript:queryDeviceRecords(${pagehelper.nextPage});">下一页</a></li>
               <li><a href="javascript:queryDeviceRecords(${pagehelper.lastPage});">最后一页</a></li>
           </c:if>
       </ul>
   </div>
</body>

</html>