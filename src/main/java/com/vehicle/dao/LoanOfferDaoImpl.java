package com.vehicle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper; 
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;



import com.vehicle.dao.*;
import com.vehicle.model.*;
import com.vehicle.controller.*;

public class LoanOfferDaoImpl implements  ILoanOfferDao{
	
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//to insert the data in table
public void saveLoanOffer(LoanOffer lo) {
		
		String getLoanId="select GR4_LOAN_DETAILS_SEQ.nextval from dual";
		int LoanId=getLoanSeq(getLoanId);
		String query="select max(gud_id) from gr4_user_details";
		int uid=jdbcTemplate.queryForObject(query, Integer.class);
			
		String sql="insert into gr4_loan_details values("+LoanId+","+uid+",'"+lo.getLoanAmount()+"','"+lo.getTenure()+"','"+lo.getInterestRate()+"','"+lo.getStatus()+"')";
		jdbcTemplate.update(sql);
	}
//to get the sequence of loan i
	private int getLoanSeq(String query) {
		int res=jdbcTemplate.queryForObject(query, int.class);
		return res;
	}
	
	
	// to get list of clients and their status
	public List<LoanOffer> getClients(){  
	    return jdbcTemplate.query("select * from  GR4_Loan_Details",new RowMapper<LoanOffer>(){  
	        public LoanOffer mapRow(ResultSet rs, int row) throws SQLException {  
	            LoanOffer lo=new LoanOffer();  
	          lo.setLoanId(rs.getInt(1));
	          lo.setUserId(rs.getInt(2));
	          lo.setLoanAmount(rs.getLong(3));
	          lo.setTenure(rs.getInt(4));
	          lo.setInterestRate(rs.getFloat(5));
	          lo.setStatus(rs.getString(6));
	            return lo;  
	        }  
	    });  
	}
	
	public List<LoanOffer> getUserData(String loginemail){  
	    return jdbcTemplate.query("select * from GR4_Loan_Details where GLD_GUD_ID = (select GUD_ID from gr4_USER_DETAILS where GUD_EMAIL= '"+loginemail+"') ",new RowMapper<LoanOffer>(){  
	        public LoanOffer mapRow(ResultSet rs, int row) throws SQLException {  
	            LoanOffer lo=new LoanOffer();  
	          lo.setLoanId(rs.getInt(1));
	          lo.setUserId(rs.getInt(2));
	          lo.setLoanAmount(rs.getLong(3));
	          lo.setTenure(rs.getInt(4));
	          lo.setInterestRate(rs.getFloat(5));
	          lo.setStatus(rs.getString(6));
	            return lo;  
	        }  
	    });  
	}
	
	
	
	// to display complete registration data on admin portal 
	public List<CompleteRegistration> displayUserRecord(int userId)
	   {
		String query = "select u.GUD_ID, u.GUD_NAME, u.GUD_GENDER, u.GUD_AGE, u.GUD_MOBILE, u.GUD_EMAIL, u.GUD_PASSWORD, u.GUD_ADDRESS, u.GUD_STATE, u.GUD_CITY, u.GUD_PINCODE, v.GVD_BRAND,v.GVD_MODEL,v.GVD_EX_SHOWROOM_PRICE, i.GID_EMPLOYMENT_TYPE,i.GID_ANNUAL_INCOME,i.GID_EXSITING_EMI , l.GLD_ID,l.GLD_LOAN_AMT,l.GLD_TENURE,l.GLD_ROI,l.GLD_STATUS from gr4_user_details u INNER JOIN gr4_vehicle_details v ON u.gud_id = v.gvd_gud_id INNER JOIN gr4_income_details i ON u.gud_id = i.gid_gud_id INNER JOIN gr4_loan_details l ON u.gud_id = l.gld_gud_id where GUD_id =  '"+userId+"'";
			return jdbcTemplate.query(query, new RowMapper<CompleteRegistration>(){

			public CompleteRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
			   
				CompleteRegistration cr = new CompleteRegistration(); 
				
				UserDetails ud = new UserDetails();
				VehicleDetails vd = new VehicleDetails();
				IncomeDetails id= new IncomeDetails();
				LoanOffer lo = new LoanOffer();
				
				
				ud.setUserId(rs.getInt(1));
				ud.setName(rs.getString(2));
				ud.setGender(rs.getString(3));
				ud.setAge(rs.getInt(4));
				ud.setMobile(rs.getLong(5));
				ud.setEmail(rs.getString(6));
				ud.setPassword(rs.getString(7));
				ud.setAddress(rs.getString(8));
				ud.setState(rs.getString(9));
				ud.setCity(rs.getString(10));
				ud.setPincode(rs.getInt(11));
				
				vd.setCarMake(rs.getString(12));
				vd.setCarModel(rs.getString(13));
				vd.setExShowroomPrice(rs.getLong(14));
				id.setTypeOfEmployment(rs.getString(15));
				id.setAnnualIncome(rs.getLong(16));
				id.setExistingEmi(rs.getLong(17));
				lo.setLoanId(rs.getInt(18));
				lo.setLoanAmount(rs.getLong(19));
				lo.setTenure(rs.getInt(20));
				lo.setInterestRate(rs.getFloat(21));
				lo.setStatus(rs.getString(22));
	           
				cr.setUd(ud);
				cr.setVd(vd);
				cr.setId(id);
				cr.setLo(lo);
	           return cr;
			}	
		});
			
	   }
	
	//to approve the loan of the user
	public void approve(int userId ){  	
	    String sql="update GR4_Loan_Details set GLD_STATUS='APPROVED' where gld_gud_id="+userId+" ";  
	     jdbcTemplate.update(sql);  
	}
	
	//to reject the loan of the user
	public void reject(int userId ){  
	
	    String sql="update GR4_Loan_Details set GLD_STATUS='REJECTED' where gld_gud_id="+userId+" ";  
	 
	     jdbcTemplate.update(sql);  
	}	
	public void createAccount(AccountDetails ad) {
		String getLoanAccNo="select GR4_LOAN_ACC.nextval from dual";
		int LoanAccNo=getLoanSeq(getLoanAccNo);
		String sql="insert into gr4_loan_account values("+LoanAccNo+","+ad.getUserId()+","+ad.getLoanAmount()+")";
		jdbcTemplate.update(sql);
	}
	
}

