package bookshop;

import java.io.IOException;import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TrolleyServlet")
public class TrolleyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		String price = request.getParameter("bookPrice");
		String userid = request.getParameter("userid");
		String count = request.getParameter("bookCount");
		String date = DateUtil.getNow();
		String orderId = String.valueOf(new Random().nextInt(1000000));
		//生成订单Bean单个
		
		float priceTotal = (Float.valueOf(price))*(Integer.valueOf(count));
		
		OrderBean bean = new OrderBean();
		bean.setBook_ID(bookid);
		bean.setUser_ID(userid);
		bean.setBook_NUM(count);
		bean.setOrder_TIME(date);
		bean.setOrder_ID(orderId);
		bean.setTotal_NUM(""+priceTotal);
		if(bean.save()){
			request.getRequestDispatcher("FindBookTrolleySuccess.jsp").forward(request,response);	
		}else{
			request.getRequestDispatcher("FindBookTrolleyFailed.jsp").forward(request,response);	
		}
//		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
