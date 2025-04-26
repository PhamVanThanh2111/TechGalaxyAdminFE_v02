package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ColorRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.AttributeResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.ColorService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/colors" })
public class ColorController {
	private final ColorService colorService;
	
	@Autowired
	public ColorController(ColorService colorService) {
		this.colorService = colorService;
	}
	

    @GetMapping
    public ModelAndView showColors(ModelAndView model) {
        DataResponse<Color> dataResponse = null;
        try {
            dataResponse = colorService.getAllColors();
            List<Color> colors = new ArrayList<>();
            if (dataResponse != null && dataResponse.getData() != null) {
                colors = (List<Color>) dataResponse.getData();
            }
            		
            System.out.println(colors);
            model.addObject("colors", colors);
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addObject("errorMessage", "Không thể tải danh sách màu sắc: " + ex.getMessage());
        }
        model.setViewName("html/Color/showColor");

		return model;
    }
    
	  @GetMapping("/add")
	    public ModelAndView addColorForm(ModelAndView model) {
	        model.addObject("color", new ColorRequest());
	        model.setViewName("html/Color/addColor");
	        return model;
	    }
	  @PostMapping("/save")
	    public String createColor(@ModelAttribute("color") ColorRequest request,
	    		   HttpSession session,
	                                  RedirectAttributes redirectAttrs) {
		    String accessToken = (String) session.getAttribute("accessToken");
	        try {
	            colorService.createColor(request, accessToken);
	            redirectAttrs.addFlashAttribute("successMessage", "Thêm color thành công!");
	        } catch (Exception ex) {
	            redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi thêm color: " + ex.getMessage());
	            return "redirect:/colors/add";
	        }
	        return "redirect:/colors";
	    }
	  
	  @PostMapping("/delete")
	  public String deleteColor(@RequestParam("id") String colorId,
	                            HttpSession session,
	                            RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");

	      try {
	          colorService.deleteColor(colorId, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Xoá color thành công!");
	      } catch (Exception e) {
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi xoá color: " + e.getMessage());
	      }

	      return "redirect:/colors";
	  }
	  
	  @PostMapping("/update")
	  public String updateColor(@ModelAttribute ColorRequest colorRequest, 
	                            @RequestParam("id") String colorId,
	                            HttpSession session,
	                            RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");
	      try {
	          colorService.updateColor(colorId, colorRequest, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Update color thành công!");
	      } catch (Exception e) {
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi update color: " + e.getMessage());
	      }
	      return "redirect:/colors";
	  }


	  @GetMapping("/update")
	  public ModelAndView showUpdateForm(@RequestParam("id") String colorId) {
	      DataResponse<Color> response = colorService.getColorById(colorId);
	      System.out.println(response.getData());

	      ModelAndView modelAndView = new ModelAndView();
	      if (response.getData() != null && !response.getData().isEmpty()) {
	          Color color = response.getData().iterator().next();
	          
	          modelAndView.addObject("color", color);
	          modelAndView.setViewName("html/Color/updateColor"); 
	      } else {
//	    	  modelAndView.setViewName("html/Color/addColor");
	      }

	      return modelAndView;

	  }
}
