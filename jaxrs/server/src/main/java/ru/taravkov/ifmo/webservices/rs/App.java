package ru.taravkov.ifmo.webservices.rs;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import ru.taravkov.ifmo.webservices.JdbcUtils;
import ru.taravkov.ifmo.webservices.rs.resource.CarResource;


/**
 * @author vtaravkov
 * @since lab4
 */
public class App {
    public static void main(String... args) throws Exception {
        JdbcUtils.createCarTable();
        JdbcUtils.createCarRecords();

        final ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        final Server server = new Server(8080);
        server.setHandler(handler);

        final ServletHolder jerseyServletHolder = handler.addServlet(ServletContainer.class, "/*");
        jerseyServletHolder.setInitOrder(0);
        jerseyServletHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "ru.taravkov.ifmo.webservices.rs.resource,com.fasterxml.jackson.jaxrs.json");

        try {
            server.start();
            server.join();
        } finally {
            server.stop();
        }
    }
}
