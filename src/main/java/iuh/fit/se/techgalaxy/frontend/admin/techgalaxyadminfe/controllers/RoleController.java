package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.RoleResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.RoleService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/roles" })
public class RoleController {
	  private final RoleService roleService;
	    private static final String ACCESS_TOKEN_SESSION_KEY = "accessToken";

	    @Autowired
	    public RoleController(RoleService roleService) {
	        this.roleService = roleService;
	    }
	@GetMapping
    public ModelAndView showAllRoles(HttpSession session, ModelAndView model) {
        List<RoleResponse> roles = new ArrayList<>();
        try {
            String accessToken = (String) session.getAttribute(ACCESS_TOKEN_SESSION_KEY);
            if (accessToken == null) {
                model.setViewName("html/Role/showRole");
                return model;
            }

            DataResponse<RoleResponse> dataResponse = roleService.findAll(accessToken);

            if (dataResponse != null && dataResponse.getData() != null) {
                roles = (List<RoleResponse>) dataResponse.getData();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        model.addObject("roles", roles);
        model.setViewName("html/Role/showRole");
        return model;
    }
	

	@GetMapping("/add")
	public ModelAndView addRole(ModelAndView model) {
		model.setViewName("html/Role/addRole");
		return model;
	}
}
