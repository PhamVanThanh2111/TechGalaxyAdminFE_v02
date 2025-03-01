package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/colors" })
public class ColorController {

	
	
	@GetMapping("/detail")
	public ModelAndView detailColor(ModelAndView model) {
		model.setViewName("html/Color/showColor");
		return model;
	}
	

	@GetMapping("/add")
	public ModelAndView addColor(ModelAndView model) {
		model.setViewName("html/Color/addColor");
		return model;
	}
}
