package org.vodafone.exam.customer.resource.h2test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test",
					"test", "");
			Statement stmt = con.createStatement();
			try{
			 stmt.executeUpdate( "DROP TABLE CUSTOMER" );
			}catch(Exception e){
				
			}
			 stmt.executeUpdate("create table CUSTOMER("
					+ "ID BIGINT AUTO_INCREMENT NOT NULL,"
					+ "NAME VARCHAR(50),"
					+ "ADDRESS VARCHAR(500),"
					+ "PHONE_NUMBER VARCHAR(12))");
			stmt.executeUpdate("ALTER TABLE CUSTOMER ADD PRIMARY KEY (ID)");
			stmt.executeUpdate("INSERT INTO CUSTOMER ( NAME ) VALUES ( 'Claudio' )");
			stmt.executeUpdate("INSERT INTO CUSTOMER ( NAME ) VALUES ( 'Bernasconi' )");

			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
			while (rs.next()) {
				String name = rs.getString("NAME");
				System.out.println(name);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}