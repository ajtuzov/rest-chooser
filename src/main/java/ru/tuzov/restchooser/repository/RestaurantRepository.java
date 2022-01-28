package ru.tuzov.restchooser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.tuzov.restchooser.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.menu WHERE r.id=:id")
    Optional<Restaurant> findWithMenu(int id);

    @Query("SELECT DISTINCT r FROM Restaurant r JOIN FETCH r.menu")
    List<Restaurant> findAllWithMenu();
}
