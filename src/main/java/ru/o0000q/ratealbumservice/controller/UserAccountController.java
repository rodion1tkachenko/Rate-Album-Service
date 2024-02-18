package ru.o0000q.ratealbumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.o0000q.ratealbumservice.entity.Album;
import ru.o0000q.ratealbumservice.entity.UsersRating;
import ru.o0000q.ratealbumservice.service.AlbumService;
import ru.o0000q.ratealbumservice.service.UserService;
import ru.o0000q.ratealbumservice.service.UsersRatingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserAccountController {
    private final UserService userService;
    private final UsersRatingService usersRatingService;
    private final AlbumService albumService;

    @GetMapping("/account/{id}")
    public String getAccountPage(@PathVariable String id,
                                 Model model) {
        setAccountAttribute(id, model);
        setUnratedAlbumsAttribute(id, model);
        return "account";
    }

    @GetMapping("/account/{id}/rateAlbum/{albumId}")
    public String rateAlbumPage(@PathVariable String id,
                            @PathVariable String albumId,
                            Model model) {
        Optional<Album> maybeAlbum = albumService.getAlbumById(Long.valueOf(albumId));
        maybeAlbum.ifPresent(album ->
                model.addAttribute("album",album));
        model.addAttribute("id",id);
        model.addAttribute("albumId",albumId);
        return "rateAlbum";
    }
    @PostMapping("/account/{id}/rateAlbum/{albumId}")
    public String rateAlbum(@PathVariable String id,
                            @PathVariable String albumId,
                            @ModelAttribute UsersRating usersRating,
                            Model model) {
        usersRating.setUser(userService.getUserById(Long.valueOf(id)).get());
        usersRating.setAlbum(albumService.getAlbumById(Long.valueOf(albumId)).get());
        usersRating.setId(null);
        usersRatingService.saveUsersRating(usersRating);
        return "account";
    }

    private void setUnratedAlbumsAttribute(String id, Model model) {
        List<Album> albums = albumService.findAll();
        List<Album> ratedAlbums = usersRatingService.getAllRatedAlbumsByUserId(Long.valueOf(id));
        model.addAttribute("unratedAlbums",
                albums.stream()
                        .filter(album -> ratedAlbums.stream().noneMatch(ratedAlbum -> ratedAlbum.getId().equals(album.getId())))
                        .collect(Collectors.toList()));
    }

    private void setAccountAttribute(String id, Model model) {
        model.addAttribute("account",
                userService.getUserById(Long.valueOf(id)).get());
    }
}
