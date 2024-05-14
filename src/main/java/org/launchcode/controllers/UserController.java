package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    private String displayAddUserForm(Model model){
       model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors){
       // if (user.getPassword().equals(confirmPassword)){
        if (!errors.hasErrors()){
           // model.addAttribute("user", user);
              return "user/index.html";
        }
        else {
           // model.addAttribute("error", "Passwords does not match");
           return "user/add.html";
        }
    }
}
