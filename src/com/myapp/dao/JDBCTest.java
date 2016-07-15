package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	
	/**
	 * <p>
	 * 		Prints the actors list from the database.
	 * </p>
	 */
	public void printActors(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","P@ss1234");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ACTOR";
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()){
				System.out.println("Actor Name: "+rset.getString("first_name")+" "+rset.getString("last_name"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		JDBCTest test = new JDBCTest();
		test.printActors();
	}

}
