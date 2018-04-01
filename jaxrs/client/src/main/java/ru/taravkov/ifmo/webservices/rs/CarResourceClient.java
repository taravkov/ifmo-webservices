package ru.taravkov.ifmo.webservices.rs;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import ru.taravkov.ifmo.webservices.entity.Car;

import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * @author vtaravkov
 * @since lab4
 */
public class CarResourceClient {
    private final Client client;

    private final String url;

    public CarResourceClient(final String url) {
        this.url = url;
        final ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        client = Client.create(clientConfig);
    }

    public Client getClient() {
        return client;
    }

    public List<Car> findAll() {
        final WebResource resource = client.resource(url);

        final ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final GenericType<List<Car>> type = new GenericType<List<Car>>() {};

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }

        return response.getEntity(type);
    }

    public List<Car> findByMake(String make) {
        final WebResource resource = client.resource(url)
                .queryParam("make", make);

        final ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        final GenericType<List<Car>> type = new GenericType<List<Car>>() {};

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }

        return response.getEntity(type);
    }

    public void create(String make, String model, String color, String vehicleClass, String rightHand) {
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("make", make)
                .queryParam("model", model)
                .queryParam("color", color)
                .queryParam("vehicleClass", vehicleClass)
                .queryParam("rightHand", rightHand);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }
    }

    public void update(String id, String make, String model, String color, String vehicleClass, String rightHand) {
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("id", id)
                .queryParam("make", make)
                .queryParam("model", model) // update X3 -> X5
                .queryParam("color", color)
                .queryParam("vehicleClass", vehicleClass)
                .queryParam("rightHand", rightHand);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }
    }

    public void delete(String id) {
        WebResource resource = client.resource("http://localhost:8080/cars")
                .queryParam("id", id);

        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        if (ClientResponse.Status.OK.getStatusCode() != response.getStatus()) {
            throw new RuntimeException();
        }
    }
}
