package com.example.secondmainproject.Controller;

import com.example.secondmainproject.service.PropertyService;
import org.springframework.core.NestedCheckedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;


@Controller
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
    @GetMapping("/propertySingle/{id}")
    public String propertySingle(@PathVariable Integer id, Model model) {

        model.addAttribute("propertySingle",propertyService.findById(id));

        return "property-single";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";

    }

}
