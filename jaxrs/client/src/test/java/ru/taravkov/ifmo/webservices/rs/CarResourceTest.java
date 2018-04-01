package ru.taravkov.ifmo.webservices.rs;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.taravkov.ifmo.webservices.entity.Car;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author vtaravkov
 * @since lab4
 */
public class CarResourceTest {
    private static Thread thread;

    private static Client client;

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

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        client = Client.create(clientConfig);
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
        final List<Car> result = findAll();
        assertEquals(2, result.size());
        assertEquals("Ford", result.get(0).getMake());
        assertEquals("BMW", result.get(1).getMake());
    }

    private List<Car> findAll() {
        WebResource resource = client.resource("http://localhost:8080/cars");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        GenericType<List<Car>> type = new GenericType<List<Car>>() {};

        assertEquals(ClientResponse.Status.OK.getStatusCode(), response.getStatus());

        return response.getEntity(type);
    }

    /**
     * @since lab4
     */
    @Test
    public void testFindByMake() {
        final List<Car> result = findByMake("Ford");
        assertEquals(1, result.size());
        assertEquals("Ford", result.get(0).getMake());
    }

    private List<Car> findByMake(String make) {
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("make", make);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        GenericType<List<Car>> type = new GenericType<List<Car>>() {};

        assertEquals(ClientResponse.Status.OK.getStatusCode(), response.getStatus());

        return response.getEntity(type);
    }

    /**
     * @since lab5
     */
    @Test
    public void testCreate() {
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("make", "Honda")
                .queryParam("model", "Civic")
                .queryParam("color", "BLACK")
                .queryParam("vehicleClass", "COMPACT")
                .queryParam("rightHand", "false");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);

        assertEquals(ClientResponse.Status.OK.getStatusCode(), response.getStatus());

        final List<Car> result = findAll();
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
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("id", "2")
                .queryParam("make", "BMW")
                .queryParam("model", "X5") // update X3 -> X5
                .queryParam("color", "SILVER")
                .queryParam("vehicleClass", "CROSSOVER")
                .queryParam("rightHand", "false");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        assertEquals(ClientResponse.Status.OK.getStatusCode(), response.getStatus());

        final List<Car> result = findByMake("BMW");
        assertEquals(1, result.size());
        assertEquals("BMW", result.get(0).getMake());
        assertEquals("X5", result.get(0).getModel());
    }

    /**
     * @since lab5
     */
    @Test
    public void testDelete() {
        final List<Car> result = findAll();

        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("id", "1");

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        assertEquals(ClientResponse.Status.OK.getStatusCode(), response.getStatus());

        final List<Car> newResult = findAll();
        assertEquals(1, result.size() - newResult.size());
    }
}
