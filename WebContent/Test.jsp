<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function test() {
		//向后台要传入的数组
		var bankIds = [1,2];
		bankIds.push(3);
		
		$.ajax({
			traditional: true,	//一定要加上这一句，这个设置为true，
			url:"TestServlet",  //data:{"bankIds":[1,2]}会转换成bankIds=1&bankIds=2&...	
			type:"post",
			data:{"bankIds":bankIds},
			success:function(){
				alert("操作成功");
			}
		});
	}
	function inputTest() {
		$("#testForm").html($("#inputTest").html());
		alert($("#testForm").serialize());
		$.ajax({
			url:"TestServlet",  
			type:"post",
			data:$("#testForm").serialize(),
			success:function(){
				alert("操作成功");
			}
		});
	}
</script>
</head>
<body>
	<button onclick="test()">Ajax测试</button>
	<br>
	<hr>
	<form action="TestServlet" method="post">
		<input type="checkbox" value="1" name="testBox"/>1
		<input type="checkbox" value="2" name="testBox"/>2
		<input type="checkbox" value="3" name="testBox"/>3
		<input type="checkbox" value="4" name="testBox"/>4
		<input type="checkbox" value="5" name="testBox"/>5
		<br>
		<input type="submit" value="提交" />
	</form>
	<hr>
	<form action="TestServlet" method="post" id="testForm">
	</form>
	<div id="inputTest">
		<input type="checkbox" value="1" name="testBox"/>1
		<input type="checkbox" value="2" name="testBox"/>2
		<input type="checkbox" value="3" name="testBox"/>3
		<input type="checkbox" value="4" name="testBox"/>4
		<input type="checkbox" value="5" name="testBox"/>5
	</div>
	<button onclick="inputTest()" >测试</button>
</body>
</html>