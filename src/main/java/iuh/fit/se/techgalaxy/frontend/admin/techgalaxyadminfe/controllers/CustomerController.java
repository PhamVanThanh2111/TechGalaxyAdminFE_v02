package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.CustomerRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public ModelAndView showCustomer(ModelAndView model) {
        model.setViewName("html/Customer/showCustomer");
        return model;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomer(ModelAndView model, @PathVariable String id) {
        model.setViewName("html/Customer/detailCustomer");
        return model;
    }

    @GetMapping("/add")
    public ModelAndView addCustomer(ModelAndView model) {
        CustomerRequest customerRequest = new CustomerRequest();
        model.setViewName("html/Customer/formCustomer");
        model.addObject("customerRequest", customerRequest);
        return model;
    }
}
