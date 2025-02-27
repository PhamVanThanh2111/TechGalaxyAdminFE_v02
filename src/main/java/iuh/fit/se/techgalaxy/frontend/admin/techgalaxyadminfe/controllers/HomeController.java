package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @GetMapping
    public ModelAndView showHome(ModelAndView model) {
        model.setViewName("index");
        return model;
    }
}
