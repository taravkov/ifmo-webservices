package ru.taravkov.ifmo.webservices.client.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.taravkov.ifmo.webservices.client.JdbcUtils;
import ru.taravkov.ifmo.webservices.client.entity.Car;

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
                "make = COALESCE(?, make) AND " +
                "model = COALESCE(?, model) AND " +
                "color = COALESCE(?, color) AND " +
                "clazz = COALESCE(?, clazz) AND " +
                "right_hand = COALESCE(?, right_hand)", new BeanPropertyRowMapper<>(Car.class), make, model, color, clazz, rightHand);
    }

    @Override
    public long create(String make, String model, Car.Color color, Car.Clazz clazz, Boolean rightHand) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(con -> {
            final PreparedStatement statement =
                    con.prepareStatement("INSERT INTO cars (make, model, color, clazz, right_hand) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, make);
            statement.setString(2, model);
            statement.setString(3, color.name());
            statement.setString(4, clazz.name());
            statement.setString(5, rightHand.toString());
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
