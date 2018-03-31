package ru.taravkov.ifmo.webservices;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author vtaravkov
 * @since lab1
 */
public class JdbcUtils {
    public static final Logger LOGGER = Logger.getLogger(JdbcUtils.class.getCanonicalName());

    static {
        final ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.ALL);
    }

    private static final String URL = "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1";

    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            synchronized (JdbcUtils.class) {
                if (jdbcTemplate == null) {
                    final JdbcDataSource dataSource = new JdbcDataSource();
                    dataSource.setURL(URL);
                    JdbcUtils.jdbcTemplate = new JdbcTemplate(dataSource);
                }
            }
        }
        return jdbcTemplate;
    }
}
