<%@ page language="java"  pageEncoding="GB2312"%>
<html> 
  <head><title>用户登入提交页面</title></head>  
  <body>
    <form action="Submit1" method="post">
         账  户  名：<input type="text" name="username"><br><br>
         用户密码：<input type="password" name="userpsw"><br><br> 
         <input type="submit" value="登录">
         <input type="button" onclick="window.location.href='CegisterIndex.jsp';" value="注册"/>
    </form>
  </body>
</html>

