package ru.taravkov.ifmo.webservices.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.taravkov.ifmo.webservices.App;
import ru.taravkov.ifmo.webservices.JdbcUtils;
import ru.taravkov.ifmo.webservices.entity.Car;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;


/**
 * @author vtaravkov
 * @since lab1
 */
public class CarDaoImpl implements CarDao {
    private final JdbcTemplate template = JdbcUtils.getJdbcTemplate();

    public List<Car> find(String make,
                          String model,
                          Car.Color color,
                          Car.Clazz clazz,
                          Boolean rightHand) {
        return template.query("SELECT * FROM cars WHERE " +
                "make = COALESCE(?, make) AND " +
                "model = COALESCE(?, model) AND " +
                "color = COALESCE(?, color) AND " +
                "clazz = COALESCE(?, clazz) AND " +
                "right_hand = COALESCE(?, right_hand)", new BeanPropertyRowMapper<>(Car.class), make, model, color, clazz, rightHand);
    }

    @Override
    public long create(String make,
                       String model,
                       Car.Color color,
                       Car.Clazz clazz,
                       Boolean rightHand) {
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
    public boolean update(long id,
                          String make,
                          String model,
                          Car.Color color,
                          Car.Clazz clazz,
                          Boolean rightHand) {
        try {
            int count = template.update(con -> {
                final PreparedStatement statement =
                        con.prepareStatement("UPDATE cars SET make = ?, model = ?, color = ?, clazz = ?, right_hand = ? " +
                                        "WHERE id = ?",
                                Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, make);
                statement.setString(2, model);
                statement.setString(3, color.name());
                statement.setString(4, clazz.name());
                statement.setString(5, rightHand.toString());
                statement.setInt(6, (int) id);
                return statement;
            });
            return count == 1;
        } catch (DataAccessException e) {
            App.LOGGER.log(Level.ALL, "Unable to update Car", e);
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            int count = template.update(con -> {
                final PreparedStatement statement =
                        con.prepareStatement("DELETE FROM cars WHERE id = ?",
                                Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, (int) id);
                return statement;
            });
            return count == 1;
        } catch (DataAccessException e) {
            App.LOGGER.log(Level.ALL, "Unable to delete Car", e);
            return false;
        }
    }
}
