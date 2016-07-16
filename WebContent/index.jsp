<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	
  	<c:set var="stuPage" value="${not empty sessionScope.stuPage}" />
  	<c:if test="${not stuPage}">
  		<%
  			response.sendRedirect("paging");
  		%>
  	</c:if>
           <h1 class="text-center">学生信息列表</h1>
           <table class="table table-hover table-striped">
           		<thead>
           			<th>id</th>
           			<th>姓名</th>
           			<th>性别</th>
           			<th>年龄</th>
           			<th>地址</th>
           		</thead>
           		<tbody>
          
           		<c:forEach items="${sessionScope.stuPage.dataList}" var="student">
           			<tr>
           				<td><c:out value="${student.id}" /></td>
           				<td><c:out value="${student.stuName}" /></td>
           				<td><c:out value="${student.gender}" /></td>
           				<td><c:out value="${student.age}" /></td>
           				<td><c:out value="${student.address}" /></td>
           			</tr>
           		</c:forEach>
           		</tbody>
           </table>
           <div class="text-center">
          	   <a class="btn btn-success" href="paging?currentPage=${sessionScope.stuPage.indexPage}">首页</a>
          	   <a class="btn btn-danger"  href="paging?currentPage=${sessionScope.stuPage.upPage}">上一页</a>
          	   <a class="btn btn-danger"  href="paging?currentPage=${sessionScope.stuPage.nextPage}">下一页</a>
           	   <a class="btn btn-success" href="paging?currentPage=${sessionScope.stuPage.endPage}">末页</a>
           </div>
    <ul class="pagination" id="pagination2"></ul>
    <script src="js/jquery.js"></script>
    <script src="js/jqPaginator.js"></script>
    <%-- <script type="text/javascript">
    function upPage(num) {
    	if (num != 1) {
	    	window.location.href="index.jsp?currentPage="+num;
    	}
    }
    
    function nextPage(num) {
    	if (num != <%=pageNum %>) {
    		window.location.href="index.jsp?currentPage="+num;
    	}
    }
    
    $.jqPaginator('#pagination2', {
        totalPages: <%=pageNum %>,
        visiblePages: 2,
        currentPage: <%=currentPage %>,
        first: '<li class="first"><a href="index.jsp">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);" onclick="upPage(<%=upPage %>)">上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" onclick="nextPage(<%=nextPage %>)">下一页</a></li>',
        last: '<li class="last"><a href="index.jsp?currentPage=<%=pageNum %>">末页</a></li>',
        onPageChange: function (num, change) {
        	
        page: '<li class="page"><a href="javascript:void(0)">{{page}}</a></li>';
        },
        onPageChange: function(num, init) {
        	
        }
    }); --%>
</script>
    
   <!--  <script src="bootstrap/js/bootstrap.min.js"></script> -->
  </body>
</html>