package bookshop;

import java.io.IOException;
import java.sql.*;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cegister extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GB2312"); 
        String name=request.getParameter("username");
        String psw=request.getParameter("userpsw");
        String id= String.valueOf(new Random().nextInt(10000));
        if(name==null||psw==null||id==null)
        	
        	request.getRequestDispatcher("CegisterError.jsp").forward(request,response);
        User zhuce=new User(name,psw);
        zhuce.setUserid(id);
        try {
        		getServletContext().setAttribute("userid", id);
        		getServletContext().setAttribute("username", name);
        		zhuce.zhuce_user(zhuce.getUsername(),zhuce.getUserid(),zhuce.getUserpsw());
			    request.getRequestDispatcher("CegisterSuccess.jsp").forward(request,response);	

		} catch (ClassNotFoundException|SQLException e) {			
			e.printStackTrace();
			request.getRequestDispatcher("CegisterError.jsp").forward(request,response);
		}  
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);		
	}
}