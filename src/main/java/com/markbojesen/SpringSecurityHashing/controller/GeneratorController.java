package com.markbojesen.SpringSecurityHashing.controller;

import com.markbojesen.SpringSecurityHashing.model.Password;
import com.markbojesen.SpringSecurityHashing.repo.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class GeneratorController {

    private Password password;

    @Autowired
    private PasswordRepository passwordRepository;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String displayForm(Model model) {
        model.addAttribute( "passwords", this.passwordRepository.findAll());
        return "submitGeneratorForm";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public String submitForm(@RequestParam String plainPassword, Model model) {
        model.addAttribute( "passwords", this.passwordRepository.findAll());
        password = new Password();
        String hashedPassword = password.generatePassword(plainPassword);
        password.setHashedPassword(hashedPassword);
        password.setPlainPassword(plainPassword);
        passwordRepository.save(password);
        return "redirect:/generate";
    }
}
