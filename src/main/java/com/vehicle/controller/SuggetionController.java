package com.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.dao.SuggetionDao;
import com.vehicle.model.Suggetion;

@Controller
public class SuggetionController {

	@Autowired
	SuggetionDao sdao;
	
	@RequestMapping(value = "/suggetion", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Suggetion u) {
		
		System.out.println("Hellooooooo");
		sdao.saveData(u);
		return new ModelAndView("index");
		
	}
	

}