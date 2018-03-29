package ru.taravkov.ifmo.webservices.service;

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
    public void test() throws InterruptedException {
        App.main();
    }

    @AfterAll
    public static void afterAll() {
        appThread.interrupt();
    }
}
