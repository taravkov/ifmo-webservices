package ru.taravkov.ifmo.webservices.ws.service;

import ru.taravkov.ifmo.webservices.OpStatus;
import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;
import ru.taravkov.ifmo.webservices.entity.Color;

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
                          @WebParam(name = "color") Color color,
                          @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                          @WebParam(name = "rightHand") Boolean rightHand) {
        return carDao.find(make, model, color, vehicleClass, rightHand);
    }

    @WebMethod(operationName = "createCar")
    public long create(@WebParam(name = "make") String make,
                          @WebParam(name = "model") String model,
                          @WebParam(name = "color") Color color,
                          @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                          @WebParam(name = "rightHand") Boolean rightHand) {
        return carDao.create(make, model, color, vehicleClass, rightHand);
    }

    @WebMethod(operationName = "updateCar")
    public OpStatus update(@WebParam(name = "id") Long id,
                           @WebParam(name = "make") String make,
                           @WebParam(name = "model") String model,
                           @WebParam(name = "color") Color color,
                           @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                           @WebParam(name = "rightHand") Boolean rightHand) {
        return carDao.update(id, make, model, color, vehicleClass, rightHand) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }

    @WebMethod(operationName = "deleteCar")
    public OpStatus delete(@WebParam(name = "id") Long id) {
        return carDao.delete(id) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }
}
