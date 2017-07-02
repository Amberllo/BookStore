<%@page import="java.util.List"%>
<%@page import="bookshop.OrderBean"%>
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


	<table width="70%" border="2">
	    <tr> 
	      <td width="20%"><div align="center">流水号</div></td>
	      <td width="20%"><div align="center">下单时间</div></td>
	      <td width="20%"><div align="center">总价</div></td>
	      <td width="5%"><div align="center">购买数量</div></td>
	      <td width="10%"><div align="center">书本id</div></td>
	      <td width="10%"><div align="center">用户id </div></td>
	    </tr>
	    <%    
	    List<OrderBean> orders = (List<OrderBean>)request.getAttribute("list"); 
	    if(orders!=null){
	    	for(OrderBean order:orders){       
	    		out.print("<tr>\n");
		    	out.print("<td>" + order.getOrder_ID() + "</td>\n");
		    	out.print("<td>" + order.getOrder_TIME() + "</td>\n");
		    	out.print("<td>" + order.getTotal_NUM() + "</td>\n");
		    	out.print("<td>" + order.getBook_NUM() + "</td>\n");
		    	out.print("<td>" + order.getBook_ID() + "</td>\n");
		    	out.print("<td>" + order.getUser_ID() + "</td>\n");
		    	
		    	out.print("</tr>\n");
			 }
	    }
	    
		%>
  </table>
</body>
</html>