package ru.o0000q.ratealbumservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAccountController {
    @GetMapping("/account")
    public String getAccountPage(){
        return "account";
    }
}
