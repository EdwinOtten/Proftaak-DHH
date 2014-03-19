package edu.avans.hartigehap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.avans.hartigehap.service.WebOrderService;

@Controller

public class WebOrderOverviewController {
	
	@Autowired
	private WebOrderService webOrderService;
	
	@RequestMapping(value = {"/weborder/overview"}, method = RequestMethod.GET)
	public String showWebOrderOverview(Model uiModel)	{
		uiModel.addAttribute("orders", webOrderService.findAll());
		
		
		return "hartigehap/webshop/orderoverview";
	}
	
	
}
