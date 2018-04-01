package ru.taravkov.ifmo.webservices.dao;


import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.entity.Color;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;

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
                   Color color,
                   VehicleClass vehicleClass,
                   Boolean rightHand);

    /**
     * @since lab2
     */
    long create(String make,
                String model,
                Color color,
                VehicleClass vehicleClass,
                Boolean rightHand);


    /**
     * @since lab2
     */
    boolean update(long id,
                   String make,
                   String model,
                   Color color,
                   VehicleClass vehicleClass,
                   Boolean rightHand);

    /**
     * @since lab2
     */
    boolean delete(long id);
}
