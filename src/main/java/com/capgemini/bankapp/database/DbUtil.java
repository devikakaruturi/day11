package com.capgemini.bankapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
@Configuration
@PropertySource("classpath:bankapp.properties")
public class DbUtil {
	@Value("${url}")
	private String url;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;
	/*private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";*/
	
	public  Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
}
}
