package ru.taravkov.ifmo.webservices.rs;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.taravkov.ifmo.webservices.entity.Car;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.ProtocolException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author vtaravkov
 * @since lab4
 */
public class CarResourceTest {
    private static Thread thread;

    private static CarResourceClient client;

    @BeforeAll
    public static void beforeAll() throws InterruptedException {
        thread = new Thread(() -> {
            try {
                App.main();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

        Thread.sleep(5000); // server startup

        client = new CarResourceClient("http://localhost:8080/cars");
    }

    @AfterAll
    public static void afterAll() {
        thread.interrupt();
    }

    /**
     * @since lab4
     */
    @Test
    public void testFindAll() {
        final List<Car> result = client.findAll();
        assertEquals(2, result.size());
        assertEquals("Ford", result.get(0).getMake());
        assertEquals("BMW", result.get(1).getMake());
    }

    /**
     * @since lab4
     */
    @Test
    public void testFindByMake() {
        final List<Car> result = client.findByMake("Ford");
        assertEquals(1, result.size());
        assertEquals("Ford", result.get(0).getMake());
    }

    /**
     * @since lab5
     */
    @Test
    public void testCreate() {
        client.create("Honda", "Civic", "BLACK", "COMPACT", "false");

        final List<Car> result = client.findAll();
        assertEquals(3, result.size());
        assertEquals("Honda", result.get(2).getMake());
        assertEquals("Civic", result.get(2).getModel());
        assertEquals(Boolean.FALSE, result.get(2).getRightHand());
    }

    /**
     * @since lab5
     */
    @Test
    public void testUpdate() throws MalformedURLException {
        client.update("2", "BMW", "X5", "SILVER", "CROSSOVER", "false");

        final List<Car> result = client.findByMake("BMW");
        assertEquals(1, result.size());
        assertEquals("BMW", result.get(0).getMake());
        assertEquals("X5", result.get(0).getModel());
    }

    /**
     * @since lab5
     */
    @Test
    public void testDelete() {
        final List<Car> result = client.findAll();

        client.delete("1");

        final List<Car> newResult = client.findAll();
        assertEquals(1, result.size() - newResult.size());
    }

    /**
     * @since lab6
     */
    @Test
    public void testCreateCarError() throws MalformedURLException {
        WebResource resource = client.getClient().resource("http://localhost:8080/cars");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);

        assertEquals(ClientResponse.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        String entity = response.getEntity(String.class);
        assertEquals("Unable to create car record: Make can not be null", entity);
    }

    /**
     * @since lab6
     */
    @Test
    public void testDeleteCarError() throws MalformedURLException {
        WebResource resource = client.getClient().resource("http://localhost:8080/cars");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        assertEquals(ClientResponse.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        String entity = response.getEntity(String.class);
        assertEquals("Unable to delete car record: Id can not be null", entity);
    }
}
