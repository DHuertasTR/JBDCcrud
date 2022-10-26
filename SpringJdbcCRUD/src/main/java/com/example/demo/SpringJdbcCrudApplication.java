package com.example.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.bo.PersonBO;
import com.example.config.ConectionFactory;
import com.example.vo.PersonVO;
import oracle.jdbc.pool.OracleDataSource;



@SpringBootApplication
public class SpringJdbcCrudApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = ConectionFactory.getConnection();
		PersonBO pb = new PersonBO(conn);
		
		//---crudTest
		
		//test de create
//		PersonVO person2 = new PersonVO( "juan", 24);
//		pb.insertPerson(person2);
		
		//test de read
//		PersonVO person1 = pb.getPerson(1);
//		System.out.println(person1.toString());
//		
//		//test de update
//		person1.setName("carlos valdez");
//		pb.updatePerson(person1);
//		person1 = pb.getPerson(1);
//		System.out.println(person1.toString());
		
		//test de delete
		pb.deletePerson(4);
		
		conn.close();
	}

}
