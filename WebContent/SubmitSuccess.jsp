<%@ page language="java"  pageEncoding="GB2312"%>
<html>
  <head>   <title>��¼��֤�ɹ�ҳ��</title> </head>  
  <body>
  		<%= (String)session.getAttribute("userid")	 %> 
  	:��½�ɹ���<br>   	      
       	�������ת������       	
      <script >
       	
       	
       	function jump(a){
       		window.location.href='ShopIndex.jsp'
       	}
       	
       	setTimeout("jump(1)",2000)
       </script>
     
  </body>
</html>

