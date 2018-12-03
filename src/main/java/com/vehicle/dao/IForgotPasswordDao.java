package com.vehicle.dao;

import java.sql.ResultSet;
import java.util.List;

import com.vehicle.model.UserDetails;

public interface IForgotPasswordDao {

	public List<UserDetails> getSecurity(UserDetails ul);
	public boolean validateAnswer(UserDetails ud);
	public int forgetchangepassowrd(UserDetails ud);	
}
