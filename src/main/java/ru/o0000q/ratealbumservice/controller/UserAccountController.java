package ru.o0000q.ratealbumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.o0000q.ratealbumservice.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserAccountController {
    private final UserService userService;
    @GetMapping("/account/{id}")
    public String getAccountPage(@PathVariable String id,
                                 Model model){
        setAccountAttribute(id, model);
        return "account";
    }

    private void setAccountAttribute(String id, Model model) {
        model.addAttribute("account",
                userService.getUserById(Long.valueOf(id)).get());
    }
}
