package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;



import com.vehicle.dao.UserDetailDao;
import com.vehicle.model.UserDetails;
@Controller
public class UserDetailController {
	
	@Autowired
	UserDetailDao pdao;//will inject dao from xml file
	
	// Save method is used to pass the set value in UserDetailDoa class to store the values in database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView save(@RequestParam("files") MultipartFile[] files,@ModelAttribute UserDetails u) {
		pdao.saveData(u,files);
		return new ModelAndView("VehicleDetails");	
	}
	
	
	

}
