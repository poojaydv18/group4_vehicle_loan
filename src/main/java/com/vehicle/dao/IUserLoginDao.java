package com.vehicle.dao;

import com.vehicle.model.UserLogin;

public interface IUserLoginDao {

	public boolean validateUser(UserLogin u);
	public String getLoanStatus(UserLogin ul);
	
}
