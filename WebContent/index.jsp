<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bussiness.*" %>
<%@ page import="entity.*" %>
<%@ page import="java.util.*" %>
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
  <%!
  	    final int pageSize = 4;
  		StudentAction stuAction = new StudentAction();
  %>
  <%
  		int currentPage = 1;
 		int nextPage=1;
 		int upPage=1;
  		String  currentPageStr = request.getParameter("currentPage");
  		if (currentPageStr != null) {
  			currentPage = Integer.parseInt(currentPageStr);
  		}
  		Page<Student> stuPage = stuAction.getStuPage(currentPage, pageSize);
  		int pageNum = stuPage.getPageNum();
  		List<Student> stuList = stuPage.getDataList();
  		
  		if (currentPage!=1 && pageNum > 1) {
  			upPage = currentPage - 1; 
  		}
  		if (currentPage<pageNum && pageNum>2) {
  			nextPage = currentPage +1;
  		}
  		if (currentPage== pageNum) {
  			nextPage = pageNum;
  		}
  %>
  
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
           		<%
           			for(Student stu : stuList) {
           		%>
           			<tr>
           				<td><%=stu.getId() %></td>
           				<td><%=stu.getStuName() %></td>
           				<td><%=stu.getGender()==1?"男":"女" %></td>
           				<td><%=stu.getAge() %></td>
           				<td><%=stu.getAddress() %></td>
           			</tr>
           		<% 	
           			}
           		
           		%>
           		</tbody>
           </table>
           <div class="text-center">
          	   <a class="btn btn-success" href="index.jsp?currentPage=1">首页</a>
          	   <a class="btn btn-danger" href="index.jsp?currentPage=<%=upPage %>">上一页</a>
          	   <a class="btn btn-danger" href="index.jsp?currentPage=<%=nextPage %>">下一页</a>
           	   <a class="btn btn-success" href="index.jsp?currentPage=<%=pageNum %>">末页</a>
           </div>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>