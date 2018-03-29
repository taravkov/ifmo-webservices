package ru.taravkov.ifmo.webservices.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.taravkov.ifmo.webservices.JdbcUtils;
import ru.taravkov.ifmo.webservices.entity.Car;

import java.sql.*;
import java.util.List;


/**
 * @author vtaravkov
 * @since lab1
 */
public class CarDaoImpl implements CarDao {
    private final JdbcTemplate template = JdbcUtils.getJdbcTemplate();

    public List<Car> find(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        return template.query("SELECT * FROM cars WHERE " +
                "make = ? AND" +
                "model = ? AND " +
                "color = ? AND " +
                "clazz = ? AND " +
                "right_hand = ?", new BeanPropertyRowMapper<Car>(), make, model, color, clazz, rightHand);
    }

    @Override
    public long create(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(con -> {
            final PreparedStatement statement =
                    con.prepareStatement("INSERT INTO cars (make, model, color, clazz, right_hand) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, make);
            statement.setObject(2, model);
            statement.setObject(3, color);
            statement.setObject(4, clazz);
            statement.setObject(5, rightHand);
            return statement;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean update(long id, String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
