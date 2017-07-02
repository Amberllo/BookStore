<%@page import="java.util.List"%>
<%@page import="bookshop.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		String userid = (String)session.getAttribute("userid");	
		String bookId = request.getParameter("bookid");
		String bookName = request.getParameter("bookName"); 
		String bookPrice = request.getParameter("bookPrice"); 
	%>
	
	
	<form  action="TrolleyServlet1" method="post">
	
		<input type="hidden" name="bookid" value="<%=bookId%>"><br><br> 	
		<input type="hidden" name="userid" value="<%=userid%>"><br><br> 
		书名：<input type="text" name="bookName" value="<%=bookName%>"><br><br>
		单价：<input type="text" readonly="1" name="bookPrice" value="<%=bookPrice%>"><br><br>
                        购买数量<input type="text" name="bookCount" ><br><br>
        <input type="submit" value="提交">
	</form>
</body>
</html>