package com.vehicle.controller;

import java.util.List;

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
	   ForgotPasswordDao fpdao;
	   
	   @RequestMapping("/forgetpassword")  
	    public ModelAndView forgetpassword( @ModelAttribute UserDetails ul){  
	        List<UserDetails> list=fpdao.getSecurity(ul);  
	        System.out.println("inside forg password");
	        System.out.println(list.get(0).getEmail()+"\t"+list.get(0).getQue());
	        return new ModelAndView("ForgetPasswordSecurity","list",list);  
	    } 
	   @RequestMapping("/checksecurityanswer")
		public ModelAndView login(ModelAndView model, @ModelAttribute UserDetails ud) {
	        System.out.println("inside security");
			if (fpdao.validateAnswer(ud)) {
				model.setViewName("ForgotChangePassword");
			} else {
				model.setViewName("UserLogin");
			}
			return model;
		}	   
}
