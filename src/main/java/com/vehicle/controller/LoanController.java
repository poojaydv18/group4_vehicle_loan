package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.dao.*;
import com.vehicle.model.*;
import com.vehicle.controller.*;



@Controller
public class LoanController {

	@Autowired
	LoanOfferDaoImpl ldao;//will inject dao from xml file
	
	// SaveLoan method is used to pass the set values in LoanDetailsDoaImpl class to store the values in database
	@RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute LoanOffer lo)
	{	
		ldao.saveLoanOffer(lo);
		return new ModelAndView("UserLogin");
	}
}
