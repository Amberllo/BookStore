package bookshop;

import java.sql.*;

public class User {
	private String username=null;
	private String userid=null;  
	private String userpsw=null; 
	//用户名
	public String getUsername() {
	     return username;
	}
	public void setUsername(String username) {
	     this.username =username;
	}
	//用户ID
	public String getUserid() { 
	    return userid;
	}
	public void setUserid(String userid) {
	     this.userid = userid;
	}
	//用户密码
	public String getUserpsw() { 
	    return userpsw;
	}
	public void setUserpsw(String userpsw) {
	     this.userpsw = userpsw;
	}

   public User(){}                  //缺省的构造方法
   public User(String uname,String upsw){   //带参数的构造方法
          username=uname;userpsw=upsw;
   		}
   
   public boolean zhuce_user(String Uname,String Uid,String Upsw) throws SQLException, ClassNotFoundException{
	      ConnectDbase cdb=new ConnectDbase();
	      Connection conn = cdb.getConnect(); 
	      String  sql="Insert into shopuser values(?,?,?)";	      
	      PreparedStatement pstmt= conn.prepareStatement(sql);
	      pstmt.setString(1,Uid);	      
	      pstmt.setString(2,Upsw);
	      pstmt.setString(3,Uname);
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
}
   //实现验证判定，当输入的用户信息正确，返回true,
   
   public String yanzheng_user(String Uname,String Upsw) throws SQLException, ClassNotFoundException, ValidateException{
	      ConnectDbase cdb=new ConnectDbase();
	      Connection conn = cdb.getConnect(); 
	      String  sql="select * from shopuser  where(user_NAME=? and user_PSW=?)";
	      PreparedStatement pstmt= conn.prepareStatement(sql);
	      pstmt.setString(1,Uname);
	      pstmt.setString(2,Upsw);
	      ResultSet  rs=pstmt.executeQuery();  
	      if(rs.next()){ 
	    	  String userid = rs.getString("user_ID");
	    	  
	    	  if(rs!=null)rs.close();   
		      if(pstmt!=null)pstmt.close();
		      if(conn!=null)conn.close(); 
		      return userid;	   	  
	      } 
	      else{
	    	  if(rs!=null)rs.close();   
		      if(pstmt!=null)pstmt.close();
		      if(conn!=null)conn.close(); 
		      throw new ValidateException();	   	  
	      } 
   }
   
}