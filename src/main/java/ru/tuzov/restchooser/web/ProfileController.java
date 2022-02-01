package ru.tuzov.restchooser.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.tuzov.restchooser.AuthUser;
import ru.tuzov.restchooser.model.User;
import ru.tuzov.restchooser.repository.UserRepository;
import ru.tuzov.restchooser.to.UserTo;
import ru.tuzov.restchooser.util.UserUtil;
import ru.tuzov.restchooser.util.exception.NotFoundException;

import java.net.URI;

import static ru.tuzov.restchooser.util.ValidationUtil.checkNew;
import static ru.tuzov.restchooser.util.ValidationUtil.checkNotFoundWithId;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = ProfileController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    static final String REST_URL = "/api/account";

    private final UserRepository repository;

    @GetMapping
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("Get logged user {}", authUser);
        return repository.findById(authUser.getId())
                .orElseThrow(() -> new NotFoundException("Not found User with id=" + authUser.getId()));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody UserTo userTo) {
        log.info("Create user from TO {}", userTo);
        checkNew(userTo);
        User created = repository.save(UserUtil.createNewFromTo(userTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser) {
        log.info("Delete user {}", authUser);
        checkNotFoundWithId(repository.delete(authUser.getId()) != 0, authUser.getId());
    }
}
