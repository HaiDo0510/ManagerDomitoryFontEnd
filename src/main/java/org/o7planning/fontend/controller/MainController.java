package org.o7planning.fontend.controller;

import org.o7planning.fontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("/")
    public String index() {

        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String pageLogin() {

        return "login";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(@RequestParam String email, @RequestParam String password) {
        if(userService.checkUser(email, password)){
            return "redirect:/home";
        } else return "redirect:/login";
    }
}
