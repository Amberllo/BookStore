<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书城主页</title>
</head>
<frameset rows="80,*">
		<%=request.getParameter("uid")%>
        <frame src="ShopIndexTitle.jsp" scrolling="no">
        <frameset cols="140,*">
             <frame src="ShopIndexLeft.jsp" scrolling="no">
             <frame src="ShopIndexRight.jsp" name="right" scrolling="auto">
        </frameset>
</frameset>
<body>
	
</body>
</html>