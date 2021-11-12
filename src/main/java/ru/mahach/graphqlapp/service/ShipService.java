package ru.mahach.graphqlapp.service;

import ru.mahach.graphqlapp.model.Ship;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для вывода и редактирования сущности {@link Ship}
 * @author Makhach Abdulazizov
 * @version 1.0
 */

public interface ShipService {

    /**
     * Создает новый {@link Ship}
     * @param name имя
     * @param status статус
     * @param flag флаг страны
     * @param yearBuilt год постройки
     * @param homePort домашний порт
     * @return созданный объект
     */
    Ship createShip(String name, String status, String flag, int yearBuilt, String homePort);

    /**
     * Возвращает все {@link Ship}
     * @param count количество возвращаемых {@link Ship}
     * @return {@link List} {@link Ship}
     */
    List<Ship> getAllShips(int count);

    /**
     * Возвращает {@link Ship} по id
     * @param id идентификатор
     * @return найденный объект {@link Ship}
     */
    Optional<Ship> getShip(Long id);
}
