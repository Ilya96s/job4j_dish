package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.DishService;

import java.util.List;

/**
 * DishController - контроллер, отвечающий за работу с блюдами
 *
 * @author Ilya Kaltygin
 */
@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class DishController {

    /**
     * Сервис по работе с блюдами
     */
    private final DishService dishService;

    /**
     * Получить список всех блюд
     *
     * @return список всех блюд
     */
    @GetMapping("/")
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    /**
     * Получить блюдо
     *
     * @param id идентификатор блюда
     * @return объект типа ResponseEntity<Dish>, содержащий объект типа Dish, найденный по указанному идентификатору
     * и статус ответа OK.
     * Если по заданному идентификатору не найден объект типа Dish, то ResponseEntity<Dish> будет содержать пустой объект типа Dish
     * и статус ответа NOT_FOUND.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var dish = dishService.findById(id);
        return new ResponseEntity<>(
                dish.orElse(new Dish()),
                dish.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Сохранить блюдо
     *
     * @param dish блюдо
     * @return объект типа ResponseEntity<Dish>, содержащий созданный объект типа Dish и статус ответа CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        return new ResponseEntity<>(
                dishService.create(dish),
                HttpStatus.CREATED
        );
    }

    /**
     * Обновить блюдо
     *
     * @param id   идентификатор блюда
     * @param dish блюдо
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если блюдо успешно обновлено,
     * иначе статус ответа NOT_FOUND.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Dish dish) {
        var update = dishService.update(dish, id);
        return new ResponseEntity<>(
                update ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Удалить блюдо
     *
     * @param id идентификатор блюда
     * @return объект типа ResponseEntity<Void>, содержащий статус ответа OK если блюдо удалено успешно,
     * иначе статус ответа NOT_FOUND.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        var delete = dishService.deleteById(id);
        return new ResponseEntity<>(
                delete ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
