package ru.taravkov.ifmo.webservices.service;

import ru.taravkov.ifmo.webservices.entity.Car;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


/**
 * @author vtaravkov
 * @since
 */
public interface CarWebService {
    List<Car> find(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand);
}
