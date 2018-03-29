package ru.taravkov.ifmo.webservices.client;

import org.junit.jupiter.api.*;
import ru.taravkov.ifmo.webservices.App;
import ru.taravkov.ifmo.webservices.client.Car;
import ru.taravkov.ifmo.webservices.client.CarService;
import ru.taravkov.ifmo.webservices.client.CarWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.taravkov.ifmo.webservices.client.Clazz.CROSSOVER;


/**
 * @author vtaravkov
 * @since
 */
public class CarWebServiceTest {
    @BeforeAll
    public static void beforeAll() {
        App.main();
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

    /**
     * @since lab2
     */
    @Test
    public void testCreate() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        webService.createCar("Honda", "Civic", Color.WHITE, Clazz.COMPACT, false);

        final List<Car> result = webService.findCar(null, null, null, null, null); // find all
        assertEquals(3, result.size());
        assertEquals("Honda", result.get(2).getMake());
        assertEquals("Civic", result.get(2).getModel());
        assertEquals(Boolean.FALSE, result.get(2).isRightHand());
    }

    /**
     * @since lab2
     */
    @Test
    public void testUpdate() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        final OpStatus status = webService.updateCar(2L, "BMW", "X5", Color.SILVER, CROSSOVER, true); // update X3 -> X5

        assertEquals(OpStatus.SUCCESS, status);

        final List<Car> result = webService.findCar("BMW", null, null, null, null);
        assertEquals(1, result.size());
        assertEquals("BMW", result.get(0).getMake());
        assertEquals("X5", result.get(0).getModel());
    }

    /**
     * @since lab2
     */
    @Test
    public void testDelete() throws MalformedURLException {
        final CarService carService = new CarService(new URL("http://localhost:8080/CarService?wsdl"));
        final CarWebService webService = carService.getCarWebServicePort();

        final List<Car> result = webService.findCar(null, null, null, null, null);  // find all

        final OpStatus status = webService.deleteCar(1L);

        assertEquals(OpStatus.SUCCESS, status);

        final List<Car> newResult = webService.findCar(null, null, null, null, null);  // find all
        assertEquals(1, result.size() - newResult.size());
    }
}
