package ru.taravkov.ifmo.webservices.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ru.taravkov.ifmo.webservices.App;


/**
 * @author vtaravkov
 * @since
 */
public class CarWebServiceTest {

    private static Thread appThread;

    @BeforeAll
    public static void beforeAll() {
        appThread = new Thread(() -> {
            try {
                App.main();
            } catch (Exception e) {
                System.out.println(e.getClass().getCanonicalName());
            }
        });
    }

    @Test
    public void testFindAll() throws InterruptedException {
        final RestTemplate template = new RestTemplate();
        template.getForObject("http://localhost:8080/CarService/find", String.class);
    }

    @AfterAll
    public static void afterAll() {
        appThread.interrupt();
    }
}
