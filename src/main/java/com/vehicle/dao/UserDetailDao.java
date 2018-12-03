package com.vehicle.dao;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.vehicle.model.UserDetails;

public class UserDetailDao implements IUserDetailDao {


	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	//to insert the user details and document in the table
	public void saveData(UserDetails u,MultipartFile... files) {
		System.out.println("inside dao save data");
		String getUserId="select GR4_USER_DETAILS_SEQ.nextval from dual";
		int userId=getUserSeq(getUserId);
		u.setUserId(userId);
		u.setFilePath(saveFiles(u, files));

		String sql= "insert into gr4_user_details values("+userId+",'"+u.getName()+"','"+u.getGender()+"','"+u.getAge()+"','"+u.getMobile()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getAddress()+"','"+u.getState()+"','"+u.getCity()+"','"+u.getPincode()+"','"+u.getQue()+"','"+u.getAns()+"','" + u.getFilePath()[0]+ "','" +  u.getFilePath()[1] + "','" +  u.getFilePath()[2] + "','" +  u.getFilePath()[3] + "')";
		 jdbcTemplate.update(sql); 
	}
	private int getUserSeq(String query) {
		int res=jdbcTemplate.queryForObject(query, int.class);
		return res;
		
	}
	
	
	//to upload the docs in local server
	public String[] saveFiles(UserDetails u, MultipartFile[] files) {
		int i = 0;
		String[] paths = new String[4];
		for (MultipartFile file : files) {
			

			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
/*				String rootPath = System.getProperty("catalina.home");
*/				File dir = new File("D:\\" + File.separator + u.getUserId());
				
			//create directory is not created
				if (!dir.exists())
				{
					dir.mkdirs();
				}
				
				// Create the file on server
				File serverFile = null;
				switch (i) {
				case 0:
					serverFile = new File(dir.getAbsolutePath() + File.separator + "Photo.jpg");
					break;
				case 1:
					serverFile = new File(dir.getAbsolutePath() + File.separator +  "Aadhar.pdf");
					break;
				case 2:
					serverFile = new File(dir.getAbsolutePath() + File.separator + "Pan.pdf");
					break;
				case 3:
					serverFile = new File(dir.getAbsolutePath() + File.separator + "PaySlip.pdf");
					break;
				}
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());

				paths[i] =serverFile.getAbsolutePath();

			} catch (Exception e) {
				System.out.println("You failed to upload  => " + e.getMessage());
				return null;
			}
			finally {
					++i;
			}

		}
		return paths; // return paths
	}
	
	// to get the file path from the table
	public String getFilePath(int userId, int fileId) {
		String colName = null;
		switch(fileId) {
		case 1: colName = "gud_photo";
		break;
		case 2: colName = "gud_aadhar";
		break;
		case 3: colName = "gud_pancard";
		break;
		case 4: colName = "gud_paySlip";
		break;
		default: return "Error Something is Wrong";
		}
		String query = "Select "+colName+" from gr4_user_details where gud_Id="+userId;
		
		String filePath = jdbcTemplate.queryForObject(query,String.class);
		
		return filePath; //return path
	}

	
}
