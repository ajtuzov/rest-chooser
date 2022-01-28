package ru.tuzov.restchooser.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tuzov.restchooser.model.Restaurant;
import ru.tuzov.restchooser.repository.RestaurantRepository;
import ru.tuzov.restchooser.util.exception.NotFoundException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/restaurant/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get Restaurant with id={}", id);
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found Restaurant with id=" + id));
    }

    @GetMapping("/{id}/with-menu")
    public Restaurant getWithMenu(@PathVariable int id) {
        log.info("get Restaurant with menu and id={}", id);
        return repository.findWithMenu(id)
                .orElseThrow(() -> new NotFoundException("Not found Restaurant with id=" + id));
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAll Restaurant");
        return repository.findAll();
    }

    @GetMapping("/with-menu")
    public List<Restaurant> getAllWithMenu() {
        log.info("get all with menu");
        return repository.findAllWithMenu();
    }
}
