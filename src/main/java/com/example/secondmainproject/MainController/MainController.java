package com.example.secondmainproject.MainController;

import com.example.secondmainproject.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    private final PropertyService propertyService;

    public MainController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public String getProperties (Model model){
        model.addAttribute("property",propertyService.getAllProperties());

        return "properties";
    }
    @GetMapping("/mainMenu")
    public String mainMenu(Model model){

        return "redirect:index";

    }
}
