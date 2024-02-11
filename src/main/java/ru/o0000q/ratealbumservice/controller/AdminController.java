package ru.o0000q.ratealbumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.o0000q.ratealbumservice.service.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @GetMapping("/{id}")
    public String welcomePage(@PathVariable String id,
                              Model model){
        setAdminAttribute(id, model);
        return "admin";
    }

    private void setAdminAttribute(String id, Model model) {
        model.addAttribute("admin",
                userService.getUserById(Long.valueOf(id)).get());
    }
}
