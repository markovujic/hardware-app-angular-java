package hr.tvz.vujic.hardwareapp.hardware.repository;

import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcHardwareRepository implements HardwareRepository {

    private static final String SELECT_ALL =
            "SELECT * FROM hardware";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public JdbcHardwareRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Hardware> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToHardware));
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        try {
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE code = ?", this::mapRowToHardware, code));
        }
        catch(EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        try {
            hardware.setId(saveHardwareDetails(hardware));
            return Optional.of(hardware);
        }
        catch (DuplicateKeyException exception) {
            return Optional.empty();
        }

    }

    @Override
    public Optional<Hardware> update(String code, Hardware updatedHardware) {
        int executed = jdbc.update("UPDATE hardware set " +
                        "name = ?, " +
                        "code = ?, " +
                        "price = ?, " +
                        "type = ?, " +
                        "stock = ? " +
                        "WHERE code = ?",
                updatedHardware.getName(),
                updatedHardware.getCode(),
                updatedHardware.getPrice(),
                updatedHardware.getType(),
                updatedHardware.getStock(),
                code
        );

        if(executed > 0) {
            return Optional.of(updatedHardware);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        jdbc.update("DELETE FROM hardware WHERE code = ?", code);
    }

    private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException {
        return new Hardware(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getDouble("price"),
                rs.getString("type"),
                rs.getInt("stock")
        );
    }

    private long saveHardwareDetails(Hardware hardware) {
        Map<String, Object> values = new HashMap<>();

        values.put("name", hardware.getName());
        values.put("code", hardware.getCode());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType());
        values.put("stock", hardware.getStock());

        return inserter.executeAndReturnKey(values).longValue();
    }


}
