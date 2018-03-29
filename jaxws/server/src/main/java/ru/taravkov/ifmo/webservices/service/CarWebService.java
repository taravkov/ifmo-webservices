package ru.taravkov.ifmo.webservices.client.service;

import ru.taravkov.ifmo.webservices.client.dao.CarDao;
import ru.taravkov.ifmo.webservices.client.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.client.entity.Car;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


/**
 * @author vtaravkov
 * @since lab1
 */
@WebService(serviceName = "CarService")
public class CarWebService {
    private final CarDao carDao = new CarDaoImpl();

    @WebMethod(operationName = "findCar")
    public List<Car> find(@WebParam(name = "make") String make,
                          @WebParam(name = "model") String model,
                          @WebParam(name = "color") Car.Color color,
                          @WebParam(name = "clazz") Car.Clazz clazz,
                          @WebParam(name = "rightHand") Boolean rightHand) {
        return carDao.find(make, model, color, clazz, rightHand);
    }
}
