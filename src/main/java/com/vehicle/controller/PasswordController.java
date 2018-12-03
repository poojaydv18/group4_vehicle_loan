package com.vehicle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.*;
import com.vehicle.dao.*;

@Controller
public class PasswordController {
	   @Autowired 
	   ForgotPasswordDao fpdao;//will inject dao from xml file
	   // this will redirect to the forgot security page and will fetch the security question based on user's email
	   @RequestMapping("/forgetpassword")  
	    public ModelAndView forgetpassword( @ModelAttribute UserDetails ul){  
	        List<UserDetails> list=fpdao.getSecurity(ul);  
	        return new ModelAndView("ForgetPasswordSecurity","list",list);  
	    } 
	   // this will check the security answer given by user 
	   @RequestMapping("/checksecurityanswer")
		public ModelAndView login(ModelAndView model, @ModelAttribute UserDetails ud, HttpServletRequest request) {
	       HttpSession session = request.getSession();
	       session.setAttribute("email", ud.getEmail());
			if (fpdao.validateAnswer(ud)) {
				model.addObject("user",ud);
				model.setViewName("ForgotChangePassword");
			} else {
				model.setViewName("UserLogin");
			}
			return model;
		}	
	   //after successful input of security answer user will get access to change the password
	   @RequestMapping("/forgetchangepassword")  
	    public ModelAndView forgetchangepassword( @ModelAttribute UserDetails ul){  
	        fpdao.forgetchangepassowrd(ul); 
	        return new ModelAndView("UserLogin");  
	    } 
}
