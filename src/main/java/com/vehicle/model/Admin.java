package com.vehicle.model;

public class Admin {

	private String adminemail;
	private String adminpassword;
	
	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminemail + ", adminPassword=" + adminpassword + "]";
	}
	
}
