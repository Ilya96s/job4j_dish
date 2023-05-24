package ru.job4j.dish.service;

import ru.job4j.dish.dto.DishDTO;
import ru.job4j.dish.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * DishService - интерфейс, описывающий бизнес-логику по работе с блюдами
 *
 * @author Ilya Kaltygin
 */
public interface DishService {

    /**
     * Получить список всех блюд
     *
     * @return список блюд
     */
    List<DishDTO> findAll();

    /**
     * Получить блюдо по идентификатору
     *
     * @param id идентификатор блюда
     * @return Optional.of(dishDTO) если блюдо по заданному идентификатору найдено, иначе Optional.empty()
     */
    Optional<DishDTO> findById(int id);

    /**
     * Сохранить блюдо
     *
     * @param dish блюдо
     * @return сохраненное блюдо
     */
    Dish create(Dish dish);

    /**
     * Обновить блюдо
     *
     * @param dish блюдо
     * @param id   идентификатор блюда
     * @return true если блюдо обновлено успешно, иначе false
     */
    boolean update(Dish dish, int id);

    /**
     * Удалить блюдо
     *
     * @param id идентификатор блюда
     * @return true если блюдо удалено успешно, иначе false
     */
    boolean deleteById(int id);
}
