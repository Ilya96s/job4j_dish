package ru.job4j.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.dish.model.Dish;

/**
 * DishRepository - хранилище блюд
 *
 * @author Ilya Kaltytin
 */
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
