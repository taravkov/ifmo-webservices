package ru.taravkov.ifmo.webservices.ws.service;

import ru.taravkov.ifmo.webservices.OpStatus;
import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.entity.Color;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;
import ru.taravkov.ifmo.webservices.ws.exception.ServiceException;
import ru.taravkov.ifmo.webservices.ws.exception.ServiceException.Detail;

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

    /**
     * @since lab1
     */
    @WebMethod(operationName = "findCar")
    public List<Car> find(@WebParam(name = "make") String make,
                          @WebParam(name = "model") String model,
                          @WebParam(name = "color") Color color,
                          @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                          @WebParam(name = "rightHand") Boolean rightHand) {
        return carDao.find(make, model, color, vehicleClass, rightHand);
    }

    /**
     * @since lab2
     */
    @WebMethod(operationName = "createCar")
    public long create(@WebParam(name = "make") String make,
                          @WebParam(name = "model") String model,
                          @WebParam(name = "color") Color color,
                          @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                          @WebParam(name = "rightHand") Boolean rightHand) {
        if (make == null) {
            throw new ServiceException("Unable to create car record", new Detail("Make can not be null"));
        }
        if (model == null) {
            throw new ServiceException("Unable to create car record", new Detail("Model can not be null"));
        }
        if (color == null) {
            throw new ServiceException("Unable to create car record", new Detail("Color can not be null"));
        }
        if (vehicleClass == null) {
            throw new ServiceException("Unable to create car record", new Detail("Vehicle class can not be null"));
        }
        if (rightHand == null) {
            throw new ServiceException("Unable to create car record", new Detail("Right hand attribute can not be null"));
        }
        return carDao.create(make, model, color, vehicleClass, rightHand);
    }

    /**
     * @since lab2
     */
    @WebMethod(operationName = "updateCar")
    public OpStatus update(@WebParam(name = "id") Long id,
                           @WebParam(name = "make") String make,
                           @WebParam(name = "model") String model,
                           @WebParam(name = "color") Color color,
                           @WebParam(name = "vehicleClass") VehicleClass vehicleClass,
                           @WebParam(name = "rightHand") Boolean rightHand) {
        if (id == null) {
            throw new ServiceException("Unable to update car record", new Detail("Id can not be null"));
        }
        if (make == null) {
            throw new ServiceException("Unable to update car record", new Detail("Make can not be null"));
        }
        if (model == null) {
            throw new ServiceException("Unable to update car record", new Detail("Model can not be null"));
        }
        if (color == null) {
            throw new ServiceException("Unable to update car record", new Detail("Color can not be null"));
        }
        if (vehicleClass == null) {
            throw new ServiceException("Unable to update car record", new Detail("Vehicle class can not be null"));
        }
        if (rightHand == null) {
            throw new ServiceException("Unable to update car record", new Detail("Right hand attribute can not be null"));
        }
        return carDao.update(id, make, model, color, vehicleClass, rightHand) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }

    /**
     * @since lab2
     */
    @WebMethod(operationName = "deleteCar")
    public OpStatus delete(@WebParam(name = "id") Long id) {
        if (id == null) {
            throw new ServiceException("Unable to delete car record", new Detail("Id can not be null"));
        }
        return carDao.delete(id) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }
}
