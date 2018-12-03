package com.vehicle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.dao.UserLoginDao;
import com.vehicle.model.UserDetails;
import com.vehicle.model.UserLogin;
@Controller
public class UserLoginController {
	
	@Autowired
	UserLoginDao uldao;//will inject dao from xml file
	
	
	@RequestMapping("/UserLogin")
	public ModelAndView login(ModelAndView model, @ModelAttribute UserLogin u, HttpServletRequest request) {
		       HttpSession session = request.getSession();
		       
		if (uldao.validateUser(u)) {
			 session.setAttribute("loginemail", u.getEmail());	
			model.setViewName("UserDashboard");

		} else {
			model.setViewName("UserLogin");
		}
		return model;
	}

	
	@RequestMapping("/loantrack")
	public ModelAndView loanTrack (HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserLogin ul) {
		HttpSession session = request.getSession();
		String email= (String) session.getAttribute("loginemail");
		ul.setEmail(email);
		String loanStatus = uldao.getLoanStatus(ul);
		System.out.println(loanStatus);
		if(loanStatus.equals("APPROVED")) {
			ModelAndView model = new ModelAndView();
			model.addObject("loanStatus",loanStatus);
			model.setViewName("LoanStatus");
			return model;
		}
		else if(loanStatus.equals("PENDING")) {
			ModelAndView model = new ModelAndView();
			model.addObject("loanStatus",loanStatus);
			model.setViewName("LoanStatus");
			return model;
		}
		else {
			ModelAndView model = new ModelAndView();
			model.addObject("loanStatus",loanStatus);
			model.setViewName("rejected");
			return model;
		}
		
		
	}
	
	

}
