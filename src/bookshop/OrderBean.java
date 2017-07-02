package bookshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderBean {
	private String order_ID;
	private String order_TIME;	
	private String user_ID;
	private String book_ID;
	private String book_NUM;
	private String total_NUM;
	public String getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(String order_ID) {
		this.order_ID = order_ID;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getBook_NUM() {
		return book_NUM;
	}
	public void setBook_NUM(String book_NUM) {
		this.book_NUM = book_NUM;
	}
	public String getBook_ID() {
		return book_ID;
	}
	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}
	public String getOrder_TIME() {
		return order_TIME;
	}
	public void setOrder_TIME(String order_TIME) {
		this.order_TIME = order_TIME;
	}
	
	public String getTotal_NUM() {
		return total_NUM;
	}
	public void setTotal_NUM(String total_NUM) {
		this.total_NUM = total_NUM;
	}
	
	public boolean save(){
		try{
		  ConnectDbase cdb=new ConnectDbase();
	      Connection conn = cdb.getConnect(); 
	      String  sql="Insert into orders values(?,?,?,?,?,?)";	      
	      PreparedStatement pstmt= conn.prepareStatement(sql);
	      
	      pstmt.setString(1,order_ID);	      
	      pstmt.setString(2,order_TIME);
	      pstmt.setString(3,user_ID);
	      pstmt.setString(4,book_ID);
	      pstmt.setString(5,book_NUM);
	      pstmt.setString(6,total_NUM);
	      int rs=pstmt.executeUpdate();  
	      if(rs==1){ 	    	
	    	  if(pstmt!=null)pstmt.close();
		      if(conn!=null)conn.close(); 
		      return true;	    	  
	      } 
	      else{	    	  
		      if(pstmt!=null)pstmt.close();
		      if(conn!=null)conn.close(); 
		      return false;	   	  
	      } 
		}catch(Exception e){
			return false;
		}
		
	}
	
	public List<OrderBean> findAll(String userid){
		List<OrderBean> list = new ArrayList<OrderBean>();
		try{
			ConnectDbase cdb=new ConnectDbase();
			Connection conn = cdb.getConnect(); 
			String  sql="SELECT * FROM orders WHERE(user_ID='"+userid+"') order by order_TIME DESC";	      
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet set = pstmt.executeQuery(sql);  
			while(set.next()){
				OrderBean bean = new OrderBean();
				bean.setBook_ID(set.getString("book_ID"));
				bean.setBook_NUM(set.getString("book_NUM"));
				bean.setOrder_ID(set.getString("order_ID"));
				bean.setTotal_NUM(set.getString("total_NUM"));
				bean.setUser_ID(set.getString("user_ID"));
				bean.setOrder_TIME(set.getString("order_TIME"));
				list.add(bean);

			}
			
//			for(int i=0;i<20;i++){
//				OrderBean bean = new OrderBean();
//				bean.setBook_ID("11");
//				bean.setBook_NUM("11");
//				bean.setOrder_ID("11");
//				bean.setTotal_NUM("11");
//				bean.setUser_ID("11");
//				bean.setOrder_TIME("11");
//				list.add(bean);
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

}
