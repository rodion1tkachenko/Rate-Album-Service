package ru.o0000q.ratealbumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.service.AlbumService;
import ru.o0000q.ratealbumservice.service.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final AlbumService albumService;
    
    @GetMapping("/{id}")
    public String welcomePage(@PathVariable String id,
                              Model model){
        setAdminAttribute(id, model);
        return "admin";
    }
    @GetMapping("/addAlbum")
    public String addNewAlbum(Model model){
        model.addAttribute("album",Album.builder().build());
        return "admin/addAlbum";
    }
    @PostMapping("/addAlbum")
    public String addNewAlbum(@ModelAttribute Album album){
        albumService.saveAlbum(album);
        return "admin/addAlbum";
    }

    private void setAdminAttribute(String id, Model model) {
        model.addAttribute("admin",
                userService.getUserById(Long.valueOf(id)).get());
    }

}
