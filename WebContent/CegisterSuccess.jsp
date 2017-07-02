<%@ page language="java"  pageEncoding="GB2312"%>
<html>
  <head>   <title>注册验证成功页面</title> </head> 
	<body> 
	  <form  action="SubmitIndex.jsp" method="post">   
	       <%=session.getAttribute("userid") %>:注册成功！<br>
	       <input type="submit" value="转到登陆界面"> 
	       
	   </form> 
	     
	 </body>  
</html>