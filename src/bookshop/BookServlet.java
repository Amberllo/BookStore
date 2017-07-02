package bookshop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet{
	
	public BookServlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312"); 
        String bookClassName=request.getParameter("bookClassName");
        
	    try {
	    	List<Book> books = new Book().findByName(bookClassName);
	    	request.setAttribute("list", books);
	        request.getRequestDispatcher("FindBook.jsp").forward(request,response);	
	        		
		} 
	    catch (Exception e ) {			
			e.printStackTrace();
			//request.getRequestDispatcher("SubmitError.jsp").forward(request,response);
		} 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}	
