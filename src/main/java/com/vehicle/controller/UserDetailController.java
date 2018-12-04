package com.vehicle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehicle.dao.IncomeDetailDaoImpl;
import com.vehicle.dao.LoanOfferDaoImpl;
import com.vehicle.dao.UserDetailDao;
import com.vehicle.dao.VehicleDetailDaoImpl;
import com.vehicle.model.IncomeDetails;
import com.vehicle.model.LoanOffer;
import com.vehicle.model.UserDetails;
import com.vehicle.model.UserLogin;
import com.vehicle.model.VehicleDetails;
@Controller
public class UserDetailController {
	
	@Autowired
	UserDetailDao pdao;//will inject dao from xml file
	@Autowired
	VehicleDetailDaoImpl vdao;//will inject dao from xml file
	@Autowired
	IncomeDetailDaoImpl idao;//will inject dao from xml file
	@Autowired
	LoanOfferDaoImpl ldao;//will inject dao from xml file
	
	
	// Save method is used to pass the set value in UserDetailDoa class to store the values in database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView save(@RequestParam("files") MultipartFile[] files,@ModelAttribute UserDetails u) {
		pdao.saveData(u,files);
		return new ModelAndView("VehicleDetails");	
	}
	// SaveVehicle method is used to pass the set values in VehicleDetailsDoaImpl class to store the values in database
		@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
		public ModelAndView save(@ModelAttribute VehicleDetails v) {		
			vdao.saveVehicle(v);
			return new ModelAndView("IncomeDetails");		
		}
		
		// SaveIncome method is used to pass the set values in IncomeDetailsDoaImpl class to store the values in database
		@RequestMapping(value = "/saveIncome", method = RequestMethod.POST)
		public ModelAndView save(@ModelAttribute IncomeDetails i) {
			idao.saveIncome(i);
			return new ModelAndView("LoanDetails");
			
		}
		
		
		
		// SaveLoan method is used to pass the set values in LoanDetailsDoaImpl class to store the values in database
		@RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
		public ModelAndView save(@ModelAttribute LoanOffer lo)
		{	
			ldao.saveLoanOffer(lo);
			return new ModelAndView("UserLogin");
		}
		
		@RequestMapping(value="/loantrack/{loginemail}")  
	    public ModelAndView reject(@PathVariable String loginemail){  
			 List<LoanOffer> list=ldao.getUserData(loginemail);  
			 return new ModelAndView("LoanStatus","list",list);  
	    }  
		
		


}
