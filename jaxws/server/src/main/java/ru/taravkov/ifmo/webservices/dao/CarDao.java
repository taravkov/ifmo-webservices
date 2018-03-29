package ru.taravkov.ifmo.webservices.client.dao;

import ru.taravkov.ifmo.webservices.client.entity.Car;

import java.util.List;


/**
 * @author vtaravkov
 * @since lab1
 */
public interface CarDao {
    /**
     * @since lab1
     */
    List<Car> find(String make,
                   String model,
                   Car.Color color,
                   Car.Clazz clazz,
                   Boolean rightHand);

    /**
     * @since lab2
     */
    long create(String make,
                String model,
                Car.Color color,
                Car.Clazz clazz,
                Boolean rightHand);


    /**
     * @since lab2
     */
    boolean update(long id,
                   String make,
                   String model,
                   Car.Color color,
                   Car.Clazz clazz,
                   Boolean rightHand);

    /**
     * @since lab2
     */
    boolean delete(long id);
}
