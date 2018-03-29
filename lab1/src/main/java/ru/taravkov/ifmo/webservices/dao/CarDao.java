package ru.taravkov.ifmo.webservices.dao;

import ru.taravkov.ifmo.webservices.entity.Car;

import java.util.List;


/**
 * @author vtaravkov
 * @since
 */
public interface CarDao {
    List<Car> find(String make,
                   String model,
                   Car.Color color,
                   Car.Clazz clazz,
                   Boolean rightHand);
}
