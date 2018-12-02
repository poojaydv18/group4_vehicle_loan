package com.vehicle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vehicle.model.LoanOffer;
import com.vehicle.model.UserDetails;

public class UserDetailDao implements IUserDetailDao {


	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	public void saveData(UserDetails u) {
		System.out.println("inside dao save data");
		String getUserId="select GR4_USER_DETAILS_SEQ.nextval from dual";
		int userId=getUserSeq(getUserId);
		String sql= "insert into gr4_user_details values("+userId+",'"+u.getName()+"','"+u.getGender()+"','"+u.getAge()+"','"+u.getMobile()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getAddress()+"','"+u.getState()+"','"+u.getCity()+"','"+u.getPincode()+"','"+u.getQue()+"','"+u.getAns()+"')";
		 jdbcTemplate.update(sql); 
	}
	private int getUserSeq(String query) {
		int res=jdbcTemplate.queryForObject(query, int.class);
		return res;
		
	}
	
	
	
}
