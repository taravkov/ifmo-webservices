package ru.taravkov.ifmo.webservices;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;


/**
 * @author vtaravkov
 * @since
 */
public class JdbcUtils {
    private static final String URL = "jdbc:h2:mem:db1";

    private static DataSource DATA_SOURCE;

    public static DataSource getDataSource() {
        if (DATA_SOURCE == null) {
            synchronized (JdbcUtils.class) {
                if (DATA_SOURCE == null) {
                    final JdbcDataSource dataSource = new JdbcDataSource();
                    dataSource.setURL(URL);
                    DATA_SOURCE = dataSource;
                }
            }
        }
        return DATA_SOURCE;
    }
}
