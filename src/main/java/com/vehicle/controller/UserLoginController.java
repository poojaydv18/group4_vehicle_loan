package com.vehicle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.dao.ForgotPasswordDao;
import com.vehicle.dao.UserLoginDao;
import com.vehicle.model.UserDetails;
import com.vehicle.model.UserLogin;
@Controller
public class UserLoginController {
	
	@Autowired
	UserLoginDao uldao;//will inject dao from xml file
	
	
	  @Autowired 
	   ForgotPasswordDao fpdao;//will inject dao from xml file	  
	@RequestMapping(value="/UserLogin", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView model, @ModelAttribute UserLogin u,  HttpServletRequest request) {		       
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
			model.setViewName("LoanStatus");
			return model;
		}
	}
	
	//invalidate the session after logout.
	
	/*@RequestMapping(value = "/userlogout")
	public ModelAndView adminLogout(ModelAndView model, HttpSession session) {
		session.invalidate();
		model.setViewName("Index");
		return model;
	}
	*/
	
	
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
