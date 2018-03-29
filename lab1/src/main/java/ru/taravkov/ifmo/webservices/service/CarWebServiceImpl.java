package ru.taravkov.ifmo.webservices.service;

import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;
import java.util.List;


/**
 * @author vtaravkov
 * @since
 */
@WebService(serviceName = "CarService")
public class CarWebServiceImpl implements CarWebService {
    private final CarDao carDao = new CarDaoImpl();

    @Override
    @WebMethod(operationName = "findCar")
    public List<Car> find(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        return carDao.find(make, model, color, clazz, rightHand);
    }
}
