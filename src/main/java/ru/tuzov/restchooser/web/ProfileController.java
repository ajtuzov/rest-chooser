package ru.tuzov.restchooser.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tuzov.restchooser.AuthUser;
import ru.tuzov.restchooser.model.User;

@Slf4j
@RestController
@RequestMapping(path = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    @GetMapping
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("Get logged user {}", authUser);
        return authUser.getUser();
    }
}
