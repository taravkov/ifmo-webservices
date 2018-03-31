package ru.taravkov.ifmo.webservices.ws;

import ru.taravkov.ifmo.webservices.JdbcUtils;
import ru.taravkov.ifmo.webservices.ws.service.CarWebService;

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
