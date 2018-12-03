package com.vehicle.dao;

import org.springframework.web.multipart.MultipartFile;

import com.vehicle.model.*;

public interface IUserDetailDao {
	
	public void saveData(UserDetails u,MultipartFile... files);
	public String getFilePath(int userId, int fileId);

}
