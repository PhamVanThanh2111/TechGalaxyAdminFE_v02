package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    public ModelAndView showAccounts(ModelAndView model) {
        model.setViewName("html/Account/showAccount");
        return model;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailAccount(ModelAndView model, @PathVariable String id) {
        model.setViewName("html/Account/detailAccount");
        return model;
    }
}
