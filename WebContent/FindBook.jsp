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
	
	<% String userid = (String)session.getAttribute("userid");	 %> 
	<script type="text/javascript">
		function addOrder(bookid,bookname){
			
			document.getElementById("addOrderResult").innerHTML =bookid +"_加入购物车成功"
			window.location.href= "FindBookTrolley.jsp?bookid="+bookid;
		}
		
		
	</script>
	<div id='addOrderResult'></div>
	<div ><%=userid%></div>
	<form action="BookServlet1" method="post">
		输入关键字：<input type="text" name="bookClassName"><br><br>
       
       <input type="submit" value="搜索" onclick="onSearch">
       
	</form>
	<table width="70%" border="2">
	    <tr> 
	      <td width="1%" height="33"> 
	        <div align="center">book_ID</div></td>
	      <td width="20%"><div align="center">书名</div></td>
	      <td width="20%"><div align="center">价钱</div></td>
	      <td width="10%"><div align="center"> </div></td>
	    </tr>
	    <%    
	    List<Book> books = (List<Book>)request.getAttribute("list"); 
	    if(books!=null){
	    	for(Book book:books){       
	    		out.print("<tr>");
		    	out.print("<td>" + book.bookId + "</td>\n");
		    	out.print("<td>" + book.bookName + "</td>\n");
		    	out.print("<td>" + book.introduce + "</td>\n");
		    	String location = "window.location.href='FindBookTrolley.jsp'";
		    	out.print("<td> <input type='button' value='下订单' onclick='addOrder('"+book.bookId+"','"+book.bookName+"')' /></td>\n");
		    	out.print("</tr>");
			 }
	    }
	    
		%>
  </table>
</body>
</html>