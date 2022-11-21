package com.example.secondmainproject.Controller;

import com.example.secondmainproject.service.UserService;
import com.example.secondmainproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class PropertyController {
    @Autowired
     private UserService userService;
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties")
    public String properties (Model model, String keyword){
        model.addAttribute("property",propertyService.getAllProperties());
        model.addAttribute("propertySingle",propertyService.getAllPropertiesByName(keyword));

        return "properties";
    }
    @GetMapping("/index")
    public String mainMenu(Model model, String keyword){
        model.addAttribute("propertySingle",propertyService.getAllPropertiesByName(keyword));

        model.addAttribute("property",propertyService.getAllProperties());


        model.addAttribute("authorities", userService.getAllRole());
        model.addAttribute("user", userService.findByEmail());


        return "index";
    }

    @GetMapping("/propertySingle/{id}")
    public String propertySingle(@PathVariable Integer id, Model model) {

        model.addAttribute("propertySingle",propertyService.findById(id));

        return "property-single";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";

    }

    @GetMapping("/search")
    public String search (Model model, String keyword,String keyword2,Integer keyword3 ){
        model.addAttribute("property",propertyService.getAllProperties());
        model.addAttribute("properties",propertyService.getAllPropertiesByName2(keyword2));
        model.addAttribute("properties",propertyService.getAllPropertiesByPrice(keyword3));
        if (keyword!= null){
            model.addAttribute("properties",propertyService.getAllPropertiesByName(keyword));

        }else {
            model.addAttribute("property",propertyService.getAllProperties());
        }
        return "search";
    }



    @GetMapping("/login")
    public String login(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "/login";
        }
        model.addAttribute("user", userService.findByEmail());
        model.addAttribute("authorities", userService.getAllRole());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/";

        }
        model.addAttribute("user", userService.findByEmail());
        model.addAttribute("authorities", userService.getAllRole());
        return "redirect:/login?logout";
    }

}
