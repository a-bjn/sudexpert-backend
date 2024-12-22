package com.example.sudexpert_backend.controller;

import com.example.sudexpert_backend.domain.Email;
import com.example.sudexpert_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService mailService) {
        this.emailService = mailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody Email email) {
        String body = "First Name: " + email.getFirstName() + "\n" +
                        "Last Name: " + email.getLastName() + "\n" +
                        "Phone number: " + email.getPhoneNumber() + "\n" +
                        "Message: " + email.getMessage();

        try {
            emailService.sendEmail("sudexpert@yahoo.com", email.getEmailAddress(), email.getSubject(), body);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
