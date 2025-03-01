package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/memories" })
public class MemoryController {

	@GetMapping("/detail")
	public ModelAndView detailMemory(ModelAndView model) {
		model.setViewName("html/Memory/showMemory");
		return model;
	}
	

	@GetMapping("/add")
	public ModelAndView addMemory(ModelAndView model) {
		model.setViewName("html/Memory/addMemory");
		return model;
	}
}
