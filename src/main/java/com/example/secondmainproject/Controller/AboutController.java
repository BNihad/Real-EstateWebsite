package com.example.secondmainproject.Controller;

import com.example.secondmainproject.service.AboutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    private AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }
    @GetMapping("/about")
    public String title(Model model) {
        model.addAttribute("parameter", aboutService.getAbout());
        return "about";

    }
}
