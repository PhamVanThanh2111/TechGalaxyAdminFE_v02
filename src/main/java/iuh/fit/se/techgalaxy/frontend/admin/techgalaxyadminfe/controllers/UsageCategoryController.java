package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.ColorRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.UsageCategoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UsageCategoryResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.ValueResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Color;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Memory;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.UsageCategoryService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/usagecategories" })
public class UsageCategoryController {

	private final UsageCategoryService usageCategoryService;

	@Autowired
	public UsageCategoryController(UsageCategoryService usageCategoryService) {
		this.usageCategoryService = usageCategoryService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("avatar");
	}

	@GetMapping
	public ModelAndView showUsageCategories(ModelAndView model) {
		List<UsageCategoryResponse> categories = new ArrayList<>();
		try {
			DataResponse<UsageCategoryResponse> dataResponse = usageCategoryService.getAllUsageCategories();
			if (dataResponse != null && dataResponse.getData() != null) {
				categories = (List<UsageCategoryResponse>) dataResponse.getData();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		model.addObject("categories", categories);
		model.setViewName("html/Usage_category/showUsageCategory");
		return model;
	}

	@GetMapping("/add")
	public ModelAndView addAttribute(ModelAndView model) {

		model.addObject("usageCategory", new UsageCategoryRequest());
		model.setViewName("html/Usage_category/addUsageCategory");
		return model;
	}

	@PostMapping("/save")
	public String createUsageCategory(@ModelAttribute("categories") UsageCategoryRequest request, HttpSession session,
			RedirectAttributes redirectAttrs) {
		String accessToken = (String) session.getAttribute("accessToken");
		try {
			usageCategoryService.createUsageCategory(request, accessToken);
			redirectAttrs.addFlashAttribute("successMessage", "Thêm UsageCategory thành công!");
		} catch (Exception ex) {
			redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi thêm UsageCategory: " + ex.getMessage());
			return "redirect:/usagecategories/add";
		}
		return "redirect:/usagecategories";
	}

	@PostMapping("/delete")
	public String deleteUsageCategory(@RequestParam("id") String usageCategoryId, HttpSession session,
			RedirectAttributes redirectAttrs) {
		String accessToken = (String) session.getAttribute("accessToken");

		try {
			usageCategoryService.deleteUsageCategory(usageCategoryId, accessToken);
			redirectAttrs.addFlashAttribute("successMessage", "Xoá UsageCategory thành công!");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi UsageCategory color: " + e.getMessage());
		}

		return "redirect:/usagecategories";
	}

	@GetMapping("/update")
	public ModelAndView showUpdateForm(@RequestParam("id") String id) {
		DataResponse<UsageCategoryResponse> response = usageCategoryService.getUsageCategoryById(id);
		System.out.println(((List<UsageCategoryResponse>) response.getData()).get(0));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usageCategory", ((List<UsageCategoryResponse>) response.getData()).get(0));
		modelAndView.setViewName("html/Usage_category/updateUsageCategory");
		return modelAndView;

	}
	
	 @PostMapping("/update")
	  public String updateCategory(@ModelAttribute UsageCategoryRequest usageCategoryRequest, 
	                            @RequestParam("id") String cateId,
	                            HttpSession session,
	                            RedirectAttributes redirectAttrs) {
	      String accessToken = (String) session.getAttribute("accessToken");
	      try {
	          usageCategoryService.updateUsageCategory(cateId, usageCategoryRequest, accessToken);
	          redirectAttrs.addFlashAttribute("successMessage", "Update UsageCategory thành công!");
	      } catch (Exception e) {
	          redirectAttrs.addFlashAttribute("errorMessage", "Lỗi khi update UsageCategory: " + e.getMessage());
	      }
	      return "redirect:/usagecategories";
	  }



}
