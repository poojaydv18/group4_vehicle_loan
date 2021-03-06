package com.vehicle.controller;

import java.util.ArrayList;  
import java.util.List;
import java.io.*;
import java.net.*;
import javax.servlet.http.HttpSession;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.*;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import com.vehicle.model.*;
import com.vehicle.dao.*;
@Controller  
public class AdminController {  
    @Autowired  
    LoanOfferDaoImpl ldao;//will inject dao from xml file  
    @Autowired  
    UserDetailDao pdao;
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView adminLogin(ModelAndView model, @ModelAttribute Admin admin, HttpSession session) {
		if (admin.getAdminemail().equals("admin@gmail.com") && admin.getAdminpassword().equals("admin123")) {
			session.setAttribute("isAdminLoggedIn", true);
			model.setViewName("AdminDashboard");
		} else {
			model.setViewName("AdminLogin");
		}
		return model;

	}
    
 
	/*@RequestMapping(value = "/adminlogout")
	public ModelAndView adminLogout(ModelAndView model, HttpSession session) {
		session.removeAttribute("isAdminLoggedIn");
		session.invalidate();
		model.setViewName("Index");
		return model;

	}*/
    /* It provides list of clients in model object */  
    @RequestMapping("/viewclient")  
    public ModelAndView viewemp(){  
        List<LoanOffer> list=ldao.getClients();  
        return new ModelAndView("ViewClients","list",list);  
    }  
    
 // this will get user id and based on that display complete registration data to admin
    @RequestMapping(value="/editclient/{userId}")  
    public ModelAndView edit(@PathVariable int userId){  
        
		List<CompleteRegistration> cr =ldao.displayUserRecord(userId);  
		ModelAndView model=new ModelAndView();
	    model.addObject("list", cr);
	    model.setViewName("ClientDetails");
		return model;		
    }  
// to display document to the admin submitted by user at the time of registration.
    @RequestMapping(value="dispfile/{userId}/{fileId}")
	public void dispFile(HttpServletResponse response , @PathVariable("userId") int userId,@PathVariable("fileId") int fileId) throws IOException {
		String fpath= pdao.getFilePath(userId, fileId);//Fetches File path from db
		InputStream in = null;
		File file = new File(fpath);
		in=new BufferedInputStream(new FileInputStream(file));
		String mimeType=URLConnection.guessContentTypeFromStream(in);
		response.setContentType(mimeType);
		IOUtils.copy(in, response.getOutputStream());//sends file to browser
	}
    
    
    @RequestMapping(value="/clientapprove/{userId}/{loanAmount}")  
    public ModelAndView approve(@PathVariable("userId") int userId,@PathVariable("loanAmount") long loanAmount, @ModelAttribute AccountDetails ad){  
       
    	ad.setLoanAmount(loanAmount);
        ad.setUserId(userId);   
		ldao.approve(userId);  
		ldao.createAccount(ad);
		return new ModelAndView("redirect:../../viewclient");  
    }  
    
    // this will accept the userid and give admin access to reject the application.
    @RequestMapping(value="/clientreject/{userId}")  
    public ModelAndView reject(@PathVariable int userId){  
        
		ldao.reject(userId);  
		return new ModelAndView("redirect:../viewclient");  
    }  
   
    
    
}  