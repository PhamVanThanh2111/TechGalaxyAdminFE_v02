package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/products")
@NoArgsConstructor
public class ProductController {

    @GetMapping("/add")
    public ModelAndView showAddProductForm(HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/formPhone");
            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }

    @PostMapping("/add")
    public String saveFullProduct() {

        try {
            return "redirect:/products";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateProductForm(@PathVariable String id, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/updateProduct");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateProduct(@PathVariable String id ) {
        try {
            return new ModelAndView("redirect:/products");
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
            return new ModelAndView("redirect:/products/edit/" + id);
        }
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {
        try {
            System.out.println("Deleting product: " + id);

            return "redirect:/products";

        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product: " + e.getMessage());
            return "redirect:/products";
        }
    }


    @GetMapping
    public ModelAndView showProductList(HttpSession session, HttpServletResponse response) {

        try {

            ModelAndView modelAndView = new ModelAndView("html/Phone/showPhone");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }

    @GetMapping("/{productId}/variants")
    public ModelAndView viewVariants(@PathVariable String productId, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/showVariants");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }


    @GetMapping("{producctID}/variants/{variantId}/details")
    public ModelAndView viewVariantDetails(@PathVariable String producctID, @PathVariable String variantId, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/showVariantDetail");
            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }


    @GetMapping("/variants/edit/{variantId}")
    public ModelAndView editVariant(@PathVariable String variantId, Model model, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/editVariant");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }

    }

    @PostMapping("/variants/update/{variantId}")
    public String updateVariant(@PathVariable String variantId, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {

        try {
            return "redirect:/products";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/home";
        }
    }


    @PostMapping("/variants/delete/{variantId}")
    public String deleteVariant(@PathVariable String variantId, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {

        try {
            return "redirect:/products";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product variant: " + e.getMessage());
            return "redirect:/products";
        }
    }


    @PostMapping("variants/details/delete/{variantDetailId}")
    public String deleteVariantDetail(@PathVariable String variantDetailId, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {

        try {

            redirectAttributes.addFlashAttribute("successMessage", "Product variant detail deleted successfully: " + variantDetailId);
            return "redirect:/products";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product variant detail: " + e.getMessage());
            return "redirect:/products";
        }
    }

    @GetMapping("/{productId}/variants/add")
    public ModelAndView addVariant(@PathVariable String productId, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/formVariants");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }

    @PostMapping("/{productId}/variants/add")
    public String saveVariant(@PathVariable String productId,

                              RedirectAttributes redirectAttributes,
                              HttpSession session,
                              HttpServletResponse response) {

        try {

            return "redirect:/products/" + productId + "/variants";

        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/home";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/home";
        }

    }

    @GetMapping("/{productId}/variants/{variantId}/details/add")
    public ModelAndView showAddVariantDetailForm(@PathVariable String productId,
                                                 @PathVariable String variantId,
                                                 Model model, HttpSession session, HttpServletResponse response) {

        try {
            ModelAndView modelAndView = new ModelAndView("html/Phone/formVariantDetails");

            return modelAndView;
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            return new ModelAndView("redirect:/home");
        }
    }


    @PostMapping("/{productId}/variants/{variantId}/details/add")
    public String saveVariantDetail(
            @PathVariable String productId,
            @PathVariable String variantId,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {

        try {
            redirectAttributes.addFlashAttribute("successMessage", "Variant detail added successfully!");
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding variant detail: " + e.getMessage());
        }
        return "redirect:/products/" + productId + "/variants/" + variantId + "/details";
    }


    @GetMapping("/{productId}/variants/{variantId}/details/{detailId}")
    public String viewDetail(
            @PathVariable String productId,
            @PathVariable String variantId,
            @PathVariable String detailId,
            Model model, HttpSession session, HttpServletResponse response) {

        try {

            return "html/Phone/detailVariantsDetails";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }


    @GetMapping("/{productId}/variants/{variantId}/details/update/{detailId}")
    public String showUpdateDetailForm(
            @PathVariable String productId,
            @PathVariable String variantId,
            @PathVariable String detailId,
            Model model, HttpSession session, HttpServletResponse response) {
        try {
            return "html/Phone/updateDetail";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/{productId}/variants/{variantId}/details/update/{detailId}")
    public String updateDetail(
            @PathVariable String productId,
            @PathVariable String variantId,
            @PathVariable String detailId,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response1) {


        try {

            redirectAttributes.addFlashAttribute("successMessage", "Product detail updated successfully!");

        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid product status: " + e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Unexpected error occurred: " + e.getMessage());
        }

        // Điều hướng về trang chi tiết
        return "redirect:/products/" + productId + "/variants/" + variantId + "/details";
    }

    @GetMapping("/{productId}/variants/{variantId}")
    public String showDetailVariant(@PathVariable String productId, @PathVariable String variantId, Model model, HttpSession session, HttpServletResponse response) {

        try {

            return "html/Phone/detailVariants";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/{productId}/variants/{variantId}/attributes")
    public String showAttributesByVariant(@PathVariable String productId, @PathVariable String variantId, Model model, HttpSession session, HttpServletResponse response) {

        try {

            return "html/Phone/showAttribute";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/{productId}/variants/{variantId}/attributes/create")
    public String showCreateAttributeValueForm(@PathVariable String productId,
                                               @PathVariable String variantId,
                                               Model model, HttpSession session, HttpServletResponse response) {
        try {

            return "html/Phone/createAttributeValue";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/{productId}/variants/{variantId}/attributes/create")
    public String createAttributeValueByVariantId(
            @PathVariable String productId,
            @PathVariable String variantId,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response1) {

        try {

            // Redirect back to the attributes page
            return "redirect:/products/" + productId + "/variants/" + variantId + "/attributes";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/{productId}/variants/{variantId}/attributes/delete/{valueId}")
    public String deleteAttributeValue(
            @PathVariable String productId,
            @PathVariable String variantId,
            @PathVariable String valueId,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response1) {
        try {

            return "redirect:/products/" + productId + "/variants/" + variantId + "/attributes";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/{productId}/variants/{variantId}/attributes/update/{valueId}")
    public String showUpdateAttributeValueForm(
            @PathVariable String productId,
            @PathVariable String variantId,
            @PathVariable String valueId,
            Model model, HttpSession session, HttpServletResponse response1) {
        try {

            return "html/Phone/updateValue";
        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/{productId}/variants/{variantId}/attributes/update/{valueId}")
    public String updateAttributeValue(
            @PathVariable String productId,
            @PathVariable String variantId,
            RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response1) {
        try {

            return "redirect:/products/" + productId + "/variants/" + variantId + "/attributes";

        } catch (HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            return "redirect:/login";
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/login";
        }
    }

}
