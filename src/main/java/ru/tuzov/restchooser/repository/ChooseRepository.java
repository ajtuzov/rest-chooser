package ru.tuzov.restchooser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.tuzov.restchooser.model.Choose;

@Transactional(readOnly = true)
public interface ChooseRepository extends JpaRepository<Choose, Integer> {

}
