package ru.o0000q.ratealbumservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.o0000q.ratealbumservice.dto.AlbumRatingDto;
import ru.o0000q.ratealbumservice.dto.ICommentAverageRate;
import ru.o0000q.ratealbumservice.entity.AlbumRating;
import ru.o0000q.ratealbumservice.service.AlbumRatingService;
import ru.o0000q.ratealbumservice.service.UsersRatingService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainPageController {
   private final AlbumRatingService albumRatingService;
   //TODO: page dont show best album
   @GetMapping
    public String mainPage(Model model){
        setBestAlbumAttribute(model);
        return "main";
    }

    private void setBestAlbumAttribute(Model model) {
        AlbumRatingDto albumRatingDto = albumRatingService.getBestAlbum();
        model.addAttribute("album",albumRatingDto);
    }


}
