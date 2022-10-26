package com.example.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.vo.PersonVO;

public class PersonBO {
	
	private Connection conn;

	public PersonBO(Connection conn) {
		this.conn = conn;
	}

	
	//Recupera una persona de la tabla personas a partir del id
	public PersonVO getPerson(int id) {
	    try {
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONS WHERE personid=" + id);

	        if(rs.next())
	        {
	            return extractPersonFromResultSet(rs);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}
	
	//Inserta una persona de la tabla personas 
	public boolean insertPerson(PersonVO person) {
	    try {
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO Persons(name, age) VALUES ( ?, ?)");
	        ps.setString(1, person.getName());
	        ps.setInt(2, person.getAge());
	        int i = ps.executeUpdate();

	      if(i == 1) {
	        return true;
	      }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return false;
	}	
	
	//Actualiza una persona de la tabla personas 
	public boolean updatePerson(PersonVO person) {
	    try {
	        PreparedStatement ps = conn.prepareStatement("UPDATE PERSONS SET name=?, age=? WHERE personid=?");
	        ps.setString(1, person.getName());
	        ps.setInt(2, person.getAge());
	        ps.setInt(3, person.getId());
	        int i = ps.executeUpdate();

	      if(i == 1) {
	    return true;
	      }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return false;
	}
	
	//Elimina la persona que se le pasa como paraámetro
	public boolean deletePerson(int id) {
	    try {
	        Statement stmt = conn.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM PERSONS WHERE PERSONID=" + id);

	      if(i == 1) {
	    return true;
	      }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return false;
	}

	//Extrae los datos de un result set y los asigna a la persona
	private PersonVO extractPersonFromResultSet(ResultSet rs) throws SQLException {
	    return new PersonVO(rs.getInt("personid"), rs.getString("name"), rs.getInt("age"));
	}	
	
	
}
