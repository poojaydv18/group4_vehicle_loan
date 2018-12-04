package com.vehicle.model;

public class CompleteRegistration {
	
	private UserDetails ud;
	private VehicleDetails vd;
	private IncomeDetails id;
	private LoanOffer lo;
	
	public UserDetails getUd() {
		return ud;
	}
	public void setUd(UserDetails ud) {
		this.ud = ud;
	}
	public VehicleDetails getVd() {
		return vd;
	}
	public void setVd(VehicleDetails vd) {
		this.vd = vd;
	}
	public IncomeDetails getId() {
		return id;
	}
	public void setId(IncomeDetails id) {
		this.id = id;
	}
	public LoanOffer getLo() {
		return lo;
	}
	public void setLo(LoanOffer lo) {
		this.lo = lo;
	}

}
