package com.avd.common.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {

	@Value("${database.url}")
	static

	String url;
	@Value("${database.user}")
	static

	String user;
	@Value("${database.password}")
	static String pass;

	@Value("${database.driver}")
	static

	String driverName = "com.mysql.jdbc.Driver";
	static Connection con = null;

	public Connection getConnection(String dbName, String username, String password) {

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() {

		try {
			System.out.println("driver name:" + driverName);
			Class.forName(driverName);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			/*
			 * url="jdbc:mysql://localhost/test"; user="root"; pass="123";
			 */

			/*
			 * url="jdbc:mysql://www.db4free.net:3306/mdmdb";
			 * user="mdmdb1234manish"; pass="123456";
			 */
			System.out.println(" This is jdbc file ");
			url="jdbc:mysql://localhost/test";
		 	user="root"; 
			pass="Advoadvo";
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
