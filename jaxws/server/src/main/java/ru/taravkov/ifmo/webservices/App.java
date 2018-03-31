package ru.taravkov.ifmo.webservices;

import ru.taravkov.ifmo.webservices.dao.CarDao;
import ru.taravkov.ifmo.webservices.dao.CarDaoImpl;
import ru.taravkov.ifmo.webservices.entity.Car;
import ru.taravkov.ifmo.webservices.service.CarWebService;

import javax.xml.ws.Endpoint;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author vtaravkov
 * @since lab1
 */
public class App {


    public static void main(String... args) {
        createTable();
        createRecords();

        Endpoint.publish("http://0.0.0.0:8080/CarService", new CarWebService());
    }

    private static void createTable() {
        JdbcUtils.getJdbcTemplate().execute("CREATE TABLE cars (" +
                "id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                "make VARCHAR, " +
                "model VARCHAR, " +
                "color VARCHAR, " +
                "clazz VARCHAR, " +
                "right_hand VARCHAR, " +
                ");");
    }

    private static void createRecords() {
        final CarDao carDao = new CarDaoImpl();
        carDao.create("Ford", "Fusion", Car.Color.BLACK, Car.Clazz.COMPACT, true);
        carDao.create("BMW", "X3", Car.Color.SILVER, Car.Clazz.CROSSOVER, true);
    }
}
