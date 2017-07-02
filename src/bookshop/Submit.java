package bookshop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GB2312"); 
        String name=request.getParameter("username");
        String psw=request.getParameter("userpsw");
//        String id=request.getParameter("userid");
	    try {
	    	String userid = new User(name,psw).yanzheng_user(name,psw);
	    	request.getSession().setAttribute("userid", userid);
	        request.getRequestDispatcher("SubmitSuccess.jsp").forward(request,response);	
	        		
		} 
	    catch (ClassNotFoundException|SQLException e ) {			
			e.printStackTrace();
			request.getRequestDispatcher("SubmitError.jsp").forward(request,response);
		} catch(ValidateException e){
			e.printStackTrace();
			request.getRequestDispatcher("SubmitError.jsp").forward(request,response);
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
