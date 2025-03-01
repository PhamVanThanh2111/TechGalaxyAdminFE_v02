package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/attributes" })
public class AttributeController {
	
	
	@GetMapping("/detail")
	public ModelAndView detailAttriute(ModelAndView model) {
		model.setViewName("html/Attribute/showAttribute");
		return model;
	}
	
	@GetMapping("/add")
	public ModelAndView addAttribute(ModelAndView model) {
		model.setViewName("html/Attribute/addAttribute");
		return model;
	}
	
}
