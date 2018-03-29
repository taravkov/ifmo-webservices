package ru.taravkov.ifmo.webservices.client;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author vtaravkov
 * @since lab1
 */
public class JdbcUtils {
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
