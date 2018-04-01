package ru.taravkov.ifmo.webservices.rs.resource;

import ru.taravkov.ifmo.webservices.OpStatus;
import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.entity.Color;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;
import ru.taravkov.ifmo.webservices.rs.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * @author vtaravkov
 * @since lab4
 */
@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {
    private final CarDao carDao = new CarDaoImpl();

    @GET
    public List<Car> find(@QueryParam("make") String make,
                          @QueryParam("model") String model,
                          @QueryParam("color") Color color,
                          @QueryParam("vehicleClass") VehicleClass vehicleClass,
                          @QueryParam("rightHand") Boolean rightHand) {
        return carDao.find(make, model, color, vehicleClass, rightHand);
    }

    @PUT
    public long create(@QueryParam("make") String make,
                       @QueryParam("model") String model,
                       @QueryParam("color") Color color,
                       @QueryParam("vehicleClass") VehicleClass vehicleClass,
                       @QueryParam("rightHand") Boolean rightHand) {
        if (make == null) {
            throw new ServiceException("Unable to create car record", "Make can not be null");
        }
        if (model == null) {
            throw new ServiceException("Unable to create car record", "Model can not be null");
        }
        if (color == null) {
            throw new ServiceException("Unable to create car record", "Color can not be null");
        }
        if (vehicleClass == null) {
            throw new ServiceException("Unable to create car record", "Vehicle class can not be null");
        }
        if (rightHand == null) {
            throw new ServiceException("Unable to create car record", "Right hand attribute can not be null");
        }
        return carDao.create(make, model, color, vehicleClass, rightHand);
    }

    @POST
    public OpStatus update(@QueryParam("id") Long id,
                           @QueryParam("make") String make,
                           @QueryParam("model") String model,
                           @QueryParam("color") Color color,
                           @QueryParam("vehicleClass") VehicleClass vehicleClass,
                           @QueryParam("rightHand") Boolean rightHand) {
        if (id == null) {
            throw new ServiceException("Unable to update car record", "Id can not be null");
        }
        if (make == null) {
            throw new ServiceException("Unable to update car record", "Make can not be null");
        }
        if (model == null) {
            throw new ServiceException("Unable to update car record", "Model can not be null");
        }
        if (color == null) {
            throw new ServiceException("Unable to update car record", "Color can not be null");
        }
        if (vehicleClass == null) {
            throw new ServiceException("Unable to update car record", "Vehicle class can not be null");
        }
        if (rightHand == null) {
            throw new ServiceException("Unable to update car record", "Right hand attribute can not be null");
        }
        return carDao.update(id, make, model, color, vehicleClass, rightHand) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }

    @DELETE
    public OpStatus delete(@QueryParam("id") Long id) {
        if (id == null) {
            throw new ServiceException("Unable to delete car record", "Id can not be null");
        }
        return carDao.delete(id) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }
}
