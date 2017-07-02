<%@ page language="java"  pageEncoding="GB2312"%>
<html>
  <head>   <title>登录验证成功页面</title> </head>  
  <body>
  		<%= (String)session.getAttribute("userid")	 %> 
  	:登陆成功！<br>   	      
       	两秒后跳转。。。       	
      <script >
       	
       	
       	function jump(a){
       		window.location.href='ShopIndex.jsp'
       	}
       	
       	setTimeout("jump(1)",2000)
       </script>
     
  </body>
</html>

