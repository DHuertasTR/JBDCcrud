package com.example.config;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;


public class ConectionFactory {

	public static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER="techcdev";
	public static final String PASS="alejandro1";
	
	public static Connection getConnection() {
		try {
			
			OracleDataSource ora =new OracleDataSource();
			ora.setURL(URL);
			ora.setUser(USER);
			ora.setPassword(PASS);
			return ora.getConnection();
			
		} catch (Exception e) {
			
			throw new RuntimeException("error conectando a la db",e);
			
		}
		
	}
	
	
}
