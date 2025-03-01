package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/usagecategories" })
public class UsageCategory {
	
	
	@GetMapping("/detail")
	public ModelAndView detailAttriute(ModelAndView model) {
		model.setViewName("html/Usage_category/showUsageCategory");
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView addAttribute(ModelAndView model) {
		model.setViewName("html/Usage_category/addUsageCategory");
		return model;
	}
	
}
