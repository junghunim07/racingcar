package com.miniproject.racingcar.repository;

import com.miniproject.racingcar.domain.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepository {

    private final JdbcTemplate template;

    public PlayerRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public void save(Player player) {
        String sql = "insert into player(name, total ,victory, defeat, point) values (?, ?, ?, ?, ?)";
        template.update(sql, player.getName(), player.getTotal(), player.getVictory(), player.getDefeat(), player.getPoint());
    }

    public Optional<Player> findOne(String name) {
        String sql = "select * from player where name=?";
        List<Player> result = template.query(sql, rowMapper(), name);
        return result.stream().findAny();
    }

    public List<Player> findAll() {
        String sql = "select * from player";
        return template.query(sql, rowMapper());
    }

    public void update(Player player) {
        String sql = "update player set total=?, victory=?, defeat=?, point=? where name=?";
        template.update(sql, player.getTotal(), player.getVictory(), player.getDefeat(), player.getPoint(), player.getName());
    }

    private RowMapper<Player> rowMapper() {
        return (rs, rowNum) -> new Player(rs.getString("name"),
                rs.getInt("total"), rs.getInt("victory"),
                rs.getInt("defeat"), rs.getInt("point"));
    }
}
