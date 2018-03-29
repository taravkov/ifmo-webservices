package ru.taravkov.ifmo.webservices.client;

import org.junit.jupiter.api.*;
import ru.taravkov.ifmo.webservices.client.Car;
import ru.taravkov.ifmo.webservices.client.CarService;
import ru.taravkov.ifmo.webservices.client.CarWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author vtaravkov
 * @since
 */
public class CarWebServiceTest {
    @BeforeAll
    public static void beforeAll() {
        ru.taravkov.ifmo.webservices.client.App.main();
    }

    /**
     * @since lab1
     */
    @Test
    public void testFindAll() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        final List<Car> result = webService.findCar(null, null, null, null, null);
        assertEquals(2, result.size());
        assertEquals("Ford", result.get(0).getMake());
        assertEquals("BMW", result.get(1).getMake());
    }

    /**
     * @since lab1
     */
    @Test
    public void testFindByMake() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        final List<Car> result = webService.findCar("Ford", null, null, null, null);
        assertEquals(1, result.size());
        assertEquals("Ford", result.get(0).getMake());
    }
}
