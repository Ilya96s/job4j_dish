package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

/**
 * DishServiceImpl - реализация сервсиа по работе с блюдами
 *
 * @author Ilya Kaltygin
 */
@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    /**
     * Хранилище блюд
     */
    private final DishRepository dishRepository;

    /**
     * Получить список всех блюд
     *
     * @return список блюд
     */
    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    /**
     * Получить блюдо по идентификатору
     *
     * @param id идентификатор блюда
     * @return Optional.of(dish) если блюдо по заданному идентификатору найдено, иначе Optional.empty()
     */
    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    /**
     * Сохранить блюдо
     *
     * @param dish блюдо
     * @return сохраненное блюдо
     */
    @Override
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    /**
     * Обновить блюдо
     *
     * @param dish блюдо
     * @param id   идентификатор блюда
     * @return true если блюдо обновлено успешно, иначе false
     */
    @Override
    public boolean update(Dish dish, int id) {
        boolean result = false;
        if (dishRepository.existsById(id)) {
            dishRepository.save(dish);
            result = true;
        }
        return result;
    }

    /**
     * Удалить блюдо
     *
     * @param id идентификатор блюда
     * @return true если блюдо удалено успешно, иначе false
     */
    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            result = true;
        }
        return result;
    }
}
