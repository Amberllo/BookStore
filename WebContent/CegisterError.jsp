<%@ page language="java"  pageEncoding="GB2312"%>
<html>
  <head> <title>注册验证出错页面</title> </head>  
  <body>  	
  	<form  action="CegisterIndex.jsp" method="post">   
	      <%=request.getParameter("userid") %>:注册失败！<br> 
	      <input type="submit" value="重新注册"> 
	   </form>  
  </body>
</html>
