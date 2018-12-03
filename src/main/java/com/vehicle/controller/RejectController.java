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
public class RejectController {
	   @Autowired  
	    LoanOfferDaoImpl ldao; //will inject dao from xml file
	   
    @RequestMapping(value="/clientreject/{userId}")  
    public ModelAndView reject(@PathVariable int userId){  
        
		ldao.reject(userId);  
		return new ModelAndView("redirect:../viewclient");  
    }  
}
