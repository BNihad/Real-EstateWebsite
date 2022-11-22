package com.example.secondmainproject.Controller;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import com.example.secondmainproject.Model.AdminRegistrationDto;
import com.example.secondmainproject.Model.PropertyDto;
import com.example.secondmainproject.service.PropertyService;
import com.example.secondmainproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;



    @GetMapping("/registration")
    public String showRegistrationAdminForm(Model model){
        model.addAttribute("admin",new AdminRegistrationDto());

        return "registration-admin";
    }

    @PostMapping("/add-admin")
    public String registerAdminAccount(@Valid @ModelAttribute("admin") AdminRegistrationDto adminRegistrationDto, BindingResult bindingResult, Model model){
        model.addAttribute("admins",userService.allAdmin());
        if(userService.userExists(adminRegistrationDto.getEmail())){
            bindingResult.addError(new FieldError("admin","email","Email istifadə edilmişdir"));
        }
        if(adminRegistrationDto.getPassword()!=null && adminRegistrationDto.getrPassword()!=null){
            if(!adminRegistrationDto.getPassword().equals(adminRegistrationDto.getrPassword())){
                bindingResult.addError(new FieldError("admin","rPassword","şifrə eyni deyil"));
            }
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("error","error");
            return "/registration-admin";
        }else
            model.addAttribute("error","success");
        userService.save(adminRegistrationDto);
        return "redirect:/registration-admin?success";
    }




    @GetMapping({"", "/"})
    public String findAll(Model model) {
        List<PropertyDto> propertyDtoList = propertyService.getAllProperties();
        model.addAttribute("property", propertyDtoList);
        return "adminPage";
    }






    @GetMapping("/property-add")
    public String propertyAdd(Model model) {
        var properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        model.addAttribute("propertieS", new PropertyDto());

        return "/addProperty";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("propertieS") PropertyDto propertyDto) throws ParseException {


        propertyService.saveProperty2(propertyDto);
        return "redirect:/admin/property-add";
    }












    @GetMapping("/editProperty/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        PropertyEntity propertyEntity = propertyService.findByParameter(id);
        model.addAttribute("property", propertyEntity);

        return "editProperty";
    }


    @PostMapping("/saveProperty")
    public String saveProduct(PropertyEntity propertyEntity) {
        propertyService.saveProperty(propertyEntity);
        return "redirect:/admin";

    }

    @GetMapping("/deleteProperty/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        propertyService.deleteProperty(id);
        return "redirect:/admin";
    }

}
