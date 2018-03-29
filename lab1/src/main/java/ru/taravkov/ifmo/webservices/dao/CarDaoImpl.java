package ru.taravkov.ifmo.webservices.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.taravkov.ifmo.webservices.JdbcUtils;
import ru.taravkov.ifmo.webservices.entity.Car;

import java.util.List;


/**
 * @author vtaravkov
 * @since
 */
public class CarDaoImpl implements CarDao {
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    public List<Car> find(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        return template.query("select * from CAR where " +
                "MAKE = ? AND " +
                "MODEL = ? AND " +
                "COLOR = ? AND " +
                "CLAZZ = ? AND " +
                "RIGHT_HAND = ?", new BeanPropertyRowMapper<Car>(), make, model, color, clazz, rightHand);
    }
}
