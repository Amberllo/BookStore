package bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Book {

	public String bookId;
	public String bookName;
	public String introduce;
	public String  price;
	
	
	public List<Book> findByName(String name) throws SQLException, ClassNotFoundException{
		List<Book> list = new ArrayList<Book>();
		
		ConnectDbase cdb=new ConnectDbase();
	      Connection conn = cdb.getConnect(); 
	      String sql = "select b.*,c.* from book as b left join bookclass as c on b.class_ID = c.class_ID WHERE b.book_NAME LIKE '%"+name+"%'";
	      PreparedStatement pstmt= conn.prepareStatement(sql);
//	      pstmt.setString(1,name);	 
	      ResultSet set = pstmt.executeQuery(sql);  
	      while(set.next()){ 
	    	  Book book = new Book();
	    	  book.bookName = set.getString("book_NAME") ; 
	    	  book.bookId = set.getString("book_ID"); 
	    	  book.price = set.getString("book_PRICE"); 
	    	  list.add(book);
    	  } 
	      if(pstmt!=null)pstmt.close();
	      if(conn!=null)conn.close(); 
		
		
		
//		for(int i=0;i<20;i++){
//			Book book = new Book();
//			book.bookId = i+"";
//			book.bookName = i+"_name";
//			book.introduce = i+"jieshhao";
//			list.add(book);
//		}
		return list;
	}
	
	
}
