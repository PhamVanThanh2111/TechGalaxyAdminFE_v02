package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/roles" })
public class RoleController {

	@GetMapping("/detail")
	public ModelAndView detailRole(ModelAndView model) {
		model.setViewName("html/Role/showRole");
		return model;
	}
	

	@GetMapping("/add")
	public ModelAndView addRole(ModelAndView model) {
		model.setViewName("html/Role/addRole");
		return model;
	}
}
