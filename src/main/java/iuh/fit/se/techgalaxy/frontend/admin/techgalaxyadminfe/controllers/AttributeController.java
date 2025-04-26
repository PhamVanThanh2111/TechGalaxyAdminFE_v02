package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.AttributeRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.AttributeResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ValueResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.AttributeService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping({ "/attributes" })
public class AttributeController {
	
	private final AttributeService attributeService;
	
	@Autowired
	public AttributeController(AttributeService attributeService) {
		this.attributeService = attributeService;
	}
	
	@GetMapping
	public ModelAndView showAttributes(ModelAndView model) {
		DataResponse<AttributeResponse> dataResponse = null;
        try {
            dataResponse = attributeService.getAllAttribute();
            
            List<AttributeResponse> attributes = new ArrayList<>();
            if (dataResponse != null && dataResponse.getData() != null) {
                attributes = (List<AttributeResponse>) dataResponse.getData();
            }

            model.addObject("attributes", attributes);
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addObject("errorMessage", "Không thể tải danh sách thuộc tính: " + ex.getMessage());
        }

        model.setViewName("html/Attribute/showAttribute");
        return model;
    }

	
	  @GetMapping("/add")
	    public ModelAndView addAttributeForm(ModelAndView model) {
	        model.addObject("attributeRequest", new AttributeRequest());
	        model.setViewName("html/Attribute/addAttribute");
	        return model;
	    }
	  @PostMapping("/save")
	    public String createAttribute(@ModelAttribute("attributeRequest") AttributeRequest request,
	    		   HttpSession session,
	                                  RedirectAttributes redirectAttrs) {
		    String accessToken = (String) session.getAttribute("accessToken");
	        try {
	            attributeService.createAttribute(request, accessToken);
	            redirectAttrs.addFlashAttribute("successMessage", "Thêm attribute thành công!");
	        } catch (Exception ex) {
	            redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi thêm attribute: " + ex.getMessage());
	            return "redirect:/attributes/add";
	        }
	        return "redirect:/attributes";
	    }
	  @PostMapping("/delete")
	  public String deleteAttribute(@RequestParam("id") String attributeId,
	                                HttpSession session,
	                                RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");
	      try {
	          attributeService.deleteAttribute(attributeId, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Xóa attribute thành công!");
	          return "redirect:/attributes";
	      } catch (Exception ex) {
	          ex.printStackTrace();
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi xóa attribute: " + ex.getMessage());
	      }
	      return "redirect:/attributes";
	  }

	  
	 @GetMapping("/value")
	    public ModelAndView showValuesByAttributeName(@RequestParam("name") String name,
	                                                  ModelAndView model) {
	        List<ValueResponse> values = new ArrayList<>();
	        try {
	            DataResponse<ValueResponse> dataResponse = 
	                attributeService.getValueByNameAtribute(name);
	            if (dataResponse != null && dataResponse.getData() != null) {
	                values = (List<ValueResponse>) dataResponse.getData();
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            model.addObject("errorMessage", 
	                           "Không thể tải giá trị cho attribute " + name 
	                           + ": " + ex.getMessage());
	        }
	        model.addObject("values", values);
	        model.addObject("attributeName", name);
	        model.setViewName("html/Attribute/valueAttribute");
	        return model;
	    }
	
}
