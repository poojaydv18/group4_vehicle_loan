package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.LoanOffer;
import com.vehicle.dao.*;

@Controller
public class ApproveController {
	   @Autowired  
	    LoanOfferDaoImpl ldao;//will inject dao from xml file
	   // this controller will accept the admin request to approve the registration and display the same back to admin.
    @RequestMapping(value="/clientapprove/{userId}")  
    public ModelAndView approve(@PathVariable int userId){  
        
		ldao.approve(userId);  
		return new ModelAndView("redirect:../viewclient");  
    }  
   
}
