package bookshop;

import java.sql.*;
public class ConnectDbase {
	private String driverName = "com.mysql.jdbc.Driver";   //驱动程序名
	private String userName = "root";       //数据库用户名
	private String userPwd = "";     //密码
	private String dbName = "bookshop";        //数据库名	
	public String getDriverName() {return driverName;}
	public void setDriverName(String driverName){this.driverName = driverName;}
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;	}
	public String getUserPwd() {return userPwd;}
	public void setUserPwd(String userPwd) {this.userPwd = userPwd;	}
	public String getDbName() {	return dbName;}
	public void setDbName(String dbName) {this.dbName = dbName;}	 
    //实现数据库连接的方法
    public Connection getConnect() throws SQLException,ClassNotFoundException { 
    	String url1="jdbc:mysql://localhost:3306/"+dbName;
        String url2 ="?user="+userName+"&password="+userPwd;   
        String url3="&useUnicode=true&characterEncoding=GB2312";
        String url =url1+url2+url3;
        Class.forName(driverName);
        return DriverManager.getConnection(url);  
   }
}

