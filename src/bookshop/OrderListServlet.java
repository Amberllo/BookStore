package bookshop;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    try {
	    	String userid =(String)request.getSession().getAttribute("userid");
	    	List<OrderBean> list = new OrderBean().findAll(userid);
	    	request.setAttribute("list", list);
	        
		} 
	    catch (Exception e ) {			
			e.printStackTrace();
			//request.getRequestDispatcher("SubmitError.jsp").forward(request,response);
		} 
	    request.getRequestDispatcher("MyOrder.jsp").forward(request,response);	  		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
