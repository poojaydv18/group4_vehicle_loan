package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.LoanOffer;
import com.vehicle.model.AccountDetails;

import com.vehicle.dao.*;

@Controller
public class ApproveController {
	   @Autowired  
	    LoanOfferDaoImpl ldao;//will inject dao from xml file
	   // this controller will accept the admin request to approve the registration and display the same back to admin.
    @RequestMapping(value="/clientapprove/{userId}/{loanAmount}")  
    public ModelAndView approve(@PathVariable("userId") int userId,@PathVariable("loanAmount") long loanAmount, @ModelAttribute AccountDetails ad){  
       
    	ad.setLoanAmount(loanAmount);
        ad.setUserId(userId);
       
		ldao.approve(userId);  
		ldao.createAccount(ad);
		return new ModelAndView("redirect:../../viewclient");  
    }  
   
}
