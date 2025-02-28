package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.OrderRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ModelAndView showOrders(ModelAndView model) {
        model.setViewName("html/Order/showOrder");
        return model;
    }

    @GetMapping("/add")
    public ModelAndView addOrder(ModelAndView model) {
        model.setViewName("html/Order/addOrder");
        model.addObject("order", new OrderRequest());
        return model;
    }
}
