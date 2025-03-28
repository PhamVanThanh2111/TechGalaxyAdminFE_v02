package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.controllers;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.CustomerRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.CustomerResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UploadFileResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.mapper.CustomerMapper;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.CustomerService;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.FileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final FileService fileService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("avatar"); // Bỏ qua field avatar
    }

    @Autowired
    public CustomerController(CustomerService customerService, FileService fileService) {
        this.customerService = customerService;
        this.fileService = fileService;
    }

    @GetMapping
    public ModelAndView getList(ModelAndView model, HttpSession session) {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken == null) {
            model.setViewName("redirect:/login");
            return model;
        }
        try {
            DataResponse<CustomerResponse> response = customerService.findAll(accessToken);

            List<CustomerResponse> customers = null;

            if (response != null) {
                customers = (List<CustomerResponse>) response.getData();
            }
            model.setViewName("html/Customer/showCustomer");
            model.addObject("customers", customers);
            return model;
        } catch (
                HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (Exception e) {
            model.setViewName("redirect:/home");
            e.printStackTrace();
            return model;
        }
    }

    @GetMapping("/add")
    public ModelAndView showForm(ModelAndView model) {
        CustomerRequest customerRequest = new CustomerRequest();
        model.setViewName("html/Customer/formCustomer");
        model.addObject("customerRequest", customerRequest);
        return model;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("customerRequest") CustomerRequest customerRequest,
                             @RequestParam("avatar") MultipartFile avatar,
                             BindingResult bindingResult,
                             ModelAndView model,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) throws IOException, URISyntaxException {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken == null) {
            model.setViewName("redirect:/login");
            return model;
        }
        try {
            if (bindingResult.hasErrors()) {
                model.setViewName("html/Customer/formCustomer");
                return model;
            }
            if (!avatar.isEmpty()) {
                DataResponse<UploadFileResponse> response = fileService.uploadFile(avatar, "customer/avatar", accessToken);
                UploadFileResponse uploadFileResponse = ((List<UploadFileResponse>) response.getData()).get(0);
                customerRequest.setAvatar(uploadFileResponse.getFileName());
            }
            boolean isSaved = false;
            if (customerRequest.getId() == null || customerRequest.getId().isEmpty()) { // add new customer
                if (customerService.save(customerRequest, accessToken).getData() != null) {
                    isSaved = true;
                }
            } else { // update customer
                if (customerRequest.getAvatar() == null || customerRequest.getAvatar().isEmpty()) {
                    CustomerResponse customerResponse = ((List<CustomerResponse>) customerService.findById(customerRequest.getId(), accessToken).getData()).get(0);
                    customerRequest.setAvatar(customerResponse.getAvatar());
                }
                if (customerService.update(customerRequest, accessToken).getData() != null) {
                    isSaved = true;
                }
            }
            if (isSaved) {
                redirectAttributes.addFlashAttribute("successMessage", "Save customer success");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Save customer failed");
            }
            model.setViewName("redirect:/customers");
            return model;
        } catch (
                HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (Exception e) {
            model.setViewName("redirect:/home");
            e.printStackTrace();
            return model;
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable String id,
                                       ModelAndView model,
                                       HttpSession session) {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken == null) {
            model.setViewName("redirect:/login");
            return model;
        }
        try {
            List<CustomerResponse> list = (List<CustomerResponse>) customerService.findById(id, accessToken).getData();
            CustomerRequest customerRequest = CustomerMapper.INSTANCE.toCustomerRequest(CustomerMapper.INSTANCE.toCustomerFromResponse(list.get(0)));
            if (customerRequest.getDateOfBirth() != null)
                model.addObject("dateOfBirth", customerRequest.getDateOfBirth().toString());
            model.setViewName("html/Customer/formCustomer");
            model.addObject("customerRequest", customerRequest);
            return model;
        } catch (
                HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (Exception e) {
            model.setViewName("redirect:/home");
            e.printStackTrace();
            return model;
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomer(@PathVariable String id,
                                       ModelAndView model,
                                       HttpSession session) {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken == null) {
            model.setViewName("redirect:/login");
            return model;
        }
        try {
            List<CustomerResponse> list = (List<CustomerResponse>) customerService.findById(id, accessToken).getData();
            CustomerRequest customerRequest = CustomerMapper.INSTANCE.toCustomerRequest(CustomerMapper.INSTANCE.toCustomerFromResponse(list.get(0)));
            model.addObject("customerRequest", customerRequest);
            model.setViewName("html/Customer/detailCustomer");

            return model;
        } catch (
                HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            model.setViewName("redirect:/home");
            return model;
        } catch (Exception e) {
            model.setViewName("redirect:/home");
            e.printStackTrace();
            return model;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable String id,
                                       ModelAndView model,
                                       HttpSession session,
                                       RedirectAttributes redirectAttributes) {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken == null) {
            model.setViewName("redirect:/login");
            return model;
        }
        try {
            customerService.delete(id, accessToken);
            redirectAttributes.addFlashAttribute("successMessage", "Delete customer success");
            model.setViewName("redirect:/customers");
            return model;
        } catch (
                HttpClientErrorException.Unauthorized e) {
            System.out.println("Unauthorized request: " + e.getMessage());
            model.setViewName("redirect:/home");
            redirectAttributes.addFlashAttribute("errorMessage", "Delete customer failed");
            return model;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Forbidden request: " + e.getMessage());
            model.setViewName("redirect:/home");
            redirectAttributes.addFlashAttribute("errorMessage", "Delete customer failed");
            return model;
        } catch (Exception e) {
            model.setViewName("redirect:/home");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Delete customer failed");
            return model;
        }
    }
}
