package ru.taravkov.ifmo.webservices;

import ru.taravkov.ifmo.webservices.service.CarWebServiceImpl;

import javax.xml.ws.Endpoint;


/**
 * @author vtaravkov
 * @since
 */
public class App {
    public static void main(String... args) {
        Endpoint.publish("http://0.0.0.0:8080/CarService", new CarWebServiceImpl());
    }
}
