package ru.taravkov.ifmo.webservices;

import ru.taravkov.ifmo.webservices.service.CarWebService;

import javax.xml.ws.Endpoint;


/**
 * @author vtaravkov
 * @since lab4
 */
public class App {
    public static void main(String... args) {
        JdbcUtils.createCarTable();
        JdbcUtils.createCarRecords();


    }
}
