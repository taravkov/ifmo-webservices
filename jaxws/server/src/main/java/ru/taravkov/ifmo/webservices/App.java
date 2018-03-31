package ru.taravkov.ifmo.webservices;

import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.VehicleClass;
import ru.taravkov.ifmo.webservices.entity.Color;
import ru.taravkov.ifmo.webservices.service.CarWebService;

import javax.xml.ws.Endpoint;


/**
 * @author vtaravkov
 * @since lab1
 */
public class App {
    public static void main(String... args) {
        JdbcUtils.createCarTable();
        JdbcUtils.createCarRecords();

        Endpoint.publish("http://0.0.0.0:8080/CarService", new CarWebService());
    }
}
