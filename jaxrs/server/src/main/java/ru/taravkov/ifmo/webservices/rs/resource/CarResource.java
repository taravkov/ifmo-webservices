package ru.taravkov.ifmo.webservices.rs.resource;

import ru.taravkov.ifmo.webservices.OpStatus;
import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.entity.Color;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;

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
        return carDao.create(make, model, color, vehicleClass, rightHand);
    }

    @POST
    public OpStatus update(@QueryParam("id") Long id,
                           @QueryParam("make") String make,
                           @QueryParam("model") String model,
                           @QueryParam("color") Color color,
                           @QueryParam("vehicleClass") VehicleClass vehicleClass,
                           @QueryParam("rightHand") Boolean rightHand) {
        return carDao.update(id, make, model, color, vehicleClass, rightHand) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }

    @DELETE
    public OpStatus delete(@QueryParam("id") Long id) {
        return carDao.delete(id) ? OpStatus.SUCCESS : OpStatus.FAILURE;
    }
}
