package ru.taravkov.ifmo.webservices;


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
