package ru.taravkov.ifmo.webservices.client;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    }

    @AfterAll
    public static void afterAll() {
        appThread.interrupt();
    }
}