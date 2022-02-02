package ru.tuzov.restchooser.web;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tuzov.restchooser.AuthUser;
import ru.tuzov.restchooser.model.Choose;
import ru.tuzov.restchooser.repository.ChooseRepository;
import ru.tuzov.restchooser.repository.RestaurantRepository;
import ru.tuzov.restchooser.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/choose")
public class ChooseController {

    private final RestaurantRepository restaurantRepository;

    private final ChooseRepository chooseRepository;

    @PostMapping(path = "/restaurant/{id}")
    public void choose(@AuthenticationPrincipal AuthUser authUser, @PathVariable int id) {
        var restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found Restaurant with id=" + id));

        var userChoose = new Choose(authUser.getUser(), restaurant, LocalDate.now(), LocalTime.now());
        chooseRepository.save(userChoose);
    }
}
