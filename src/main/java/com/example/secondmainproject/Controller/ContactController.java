package com.example.secondmainproject.Controller;

import com.example.secondmainproject.Model.ContactDto;
import com.example.secondmainproject.service.ContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void saveContact(@RequestBody ContactDto contactDto) {
        contactService.saveContact(contactDto);
    }

}