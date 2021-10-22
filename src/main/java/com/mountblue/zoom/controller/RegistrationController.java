package com.mountblue.zoom.controller;

import com.mountblue.zoom.entity.User;
import com.mountblue.zoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user){
        if(userService.findByEmail(user.getEmail())==null) {
            user.setRole("OpenViduRole.PUBLISHER");
            userService.save(user);
        }else {
            return "redirect:/register?error";
        }
        return "redirect:/register?success";
    }
}
