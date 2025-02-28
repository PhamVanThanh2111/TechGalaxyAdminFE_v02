package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.SystemUserRequestDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/systemUsers")
public class SystemUserController {

    @GetMapping
    public ModelAndView showSystemUser(ModelAndView model) {
        model.setViewName("html/SystemUser/showSystemUser");
        return model;
    }

    @GetMapping("/add")
    public ModelAndView addSystemUser(ModelAndView model) {
        SystemUserRequestDTO requestDTO = new SystemUserRequestDTO();
        model.addObject("systemUserRequestDTO", requestDTO);
        model.setViewName("html/SystemUser/formSystemUser");
        return model;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailSystemUser(ModelAndView model, @PathVariable String id) {
        model.setViewName("html/SystemUser/detailSystemUser");
        return model;
    }
}
