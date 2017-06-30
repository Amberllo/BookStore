<%@ page language="java"  pageEncoding="GB2312"%>
<html>
  <head>   <title>登录验证成功页面</title> </head>  
  <body>
  	<%=(String)request.getParameter("userid")%> 	
  	:登陆成功！<br>   	      
       	两秒后跳转。。。       	
      <script >
       		setTimeout("window.location.href='ShopIndex.jsp'",2000)
       </script>
     
  </body>
</html>

