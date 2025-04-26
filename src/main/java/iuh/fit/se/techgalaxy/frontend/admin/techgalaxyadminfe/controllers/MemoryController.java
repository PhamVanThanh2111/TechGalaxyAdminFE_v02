package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ColorRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.MemoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Memory;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.MemoryService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/memories" })
public class MemoryController {

	private final MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @GetMapping
    public ModelAndView showMemories(ModelAndView model) {
        DataResponse<Memory> dataResponse;
        List<Memory> memories = new ArrayList<>();
        try {
            dataResponse = memoryService.getAllMemories();
            if (dataResponse != null && dataResponse.getData() != null) {
                memories = (List<Memory>) dataResponse.getData();
            }
            model.addObject("memories", memories);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.setViewName("html/Memory/showMemory");
        return model;
    }


	@GetMapping("/add")
	public ModelAndView addMemory(ModelAndView model) {
		model.addObject("memory",new MemoryRequest());
		model.setViewName("html/Memory/addMemory");
		return model;
	}
	
	  @PostMapping("/save")
	    public String createMemory(@ModelAttribute("memory") MemoryRequest request,
	    		   HttpSession session,
	                                  RedirectAttributes redirectAttrs) {
		    String accessToken = (String) session.getAttribute("accessToken");
	        try {
	            memoryService.createMemory(request, accessToken);
	            redirectAttrs.addFlashAttribute("successMessage", "Thêm memory thành công!");
	        } catch (Exception ex) {
	            redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi thêm memory: " + ex.getMessage());
	            return "redirect:/memories/add";
	        }
	        return "redirect:/memories";
	    }
	  
	  
	  @PostMapping("/delete")
	  public String deleteMemory(@RequestParam("id") String memoryId,
	                            HttpSession session,
	                            RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");

	      try {
	          memoryService.deleteMemory(memoryId, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Xoá memory thành công!");
	      } catch (Exception e) {
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi xoá memory: " + e.getMessage());
	      }

	      return "redirect:/memories";
	  }
	  
	  @PostMapping("/update")
	  public String updateColor(@ModelAttribute MemoryRequest memoryRequest, 
	                            @RequestParam("id") String memoryId,
	                            HttpSession session,
	                            RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");
	      try {
	          memoryService.updateMemory(memoryId, memoryRequest, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Update memory thành công!");
	      } catch (Exception e) {
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi update memory: " + e.getMessage());
	      }
	      return "redirect:/memories";
	  }
	
	@GetMapping("/update")
	public ModelAndView updateMemoryForm(@RequestParam("id") String id, ModelAndView model) {
	    try {
	    	 DataResponse<Memory> memory = memoryService.getMemoryById(id);
	    	 System.out.println(memory.getData());
	        model.addObject("memory", ((List<Memory>) memory.getData()).get(0));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    model.setViewName("html/Memory/updateMemory");
	    return model;
	}
}
