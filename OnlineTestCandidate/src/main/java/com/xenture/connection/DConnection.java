package com.xenture.connection;

import java.sql.*;

public class DConnection {

	
	//Production DB Connection
	 /*private static final String Driver="com.mysql.jdbc.Driver";
	 private static final String uri="jdbc:mysql://xentureprodserver.ct6mkaej3dnq.ap-south-1.rds.amazonaws.com:3306/trabaajodb";
	 private static final String username="xentureadmin";
  	 private static final String pass="trabaajo0212";*/
  	 
  	//DEV TEST FORM CLOUD9
	private static final String Driver="com.mysql.jdbc.Driver";
	//private static final String uri="jdbc:mysql://onlinetestdev.ct6mkaej3dnq.ap-south-1.rds.amazonaws.com:3306/onlineTest";
	private static final String uri="jdbc:mysql://xenturedbserver.ct6mkaej3dnq.ap-south-1.rds.amazonaws.com:3306/trabaajodb";
    private static final String username="xenture";
    private static final String pass="trabaajo123";
  	 
  	
    //Local System
 /* private static final String Driver="com.mysql.jdbc.Driver";
	private static final String uri="jdbc:mysql://localhost:3306/xenture_online_test";
    private static final String username="root";
    private static final String pass="";
 */

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(uri, username, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
}