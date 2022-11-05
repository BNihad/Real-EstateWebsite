package com.example.secondmainproject.MainController;

import com.example.secondmainproject.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    private final PropertyService propertyService;

    public MainController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties")
    public String properties (Model model){
        model.addAttribute("property",propertyService.getAllProperties());

        return "properties";
    }
    @GetMapping("/index")
    public String mainMenu(Model model){
        model.addAttribute("property",propertyService.getAllProperties());
        return "index";
    }
    @GetMapping("/propertySingle")
    public String propertySingle(Model model) {
        model.addAttribute("property",propertyService.getAllProperties());
        return "property-single";
    }
}
