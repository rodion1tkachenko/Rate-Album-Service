package ru.o0000q.ratealbumservice.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.o0000q.ratealbumservice.service.UserService;


import java.io.IOException;

@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private  UserService userService;


    protected String determineTargetUrl(Authentication authentication) {
        User user = (User) authentication.getPrincipal(); // Получаем объект User из Spring Security
        if (user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "/admin/" + getId(user); // Перенаправляем на страницу админа с его именем пользователя
        } else {
            return "/user/account/" +  getId(user); // Перенаправляем на страницу пользователя с его именем пользователя
        }
    }

    private Long getId(User user) {
        return userService.getUserByLogin(user.getUsername()).get().getId();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        response.sendRedirect(targetUrl);
    }
}
