package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tutorial.entity.Usr;

import java.util.List;

@Repository
@Transactional
public class EmpRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final RowMapper<Usr> rowMapper = (rs, i) -> {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        return new Usr(id, name);
    };

    public List<Usr> findAll() {
        return namedParameterJdbcTemplate.query("SELECT id, name FROM usr ORDER BY id", rowMapper);
    }

    public Usr findOne(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject("SELECT id, name FROM usr WHERE id = :id", param, rowMapper);
    }

    @Transactional
    public Usr save(Usr usr) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(usr);
        if (usr.id == null) {
            namedParameterJdbcTemplate.update("INSERT INTO usr(name) VALUES (:name)", param);
        } else {
            namedParameterJdbcTemplate.update("UPDATE usr SET name = :name WHERE id = :id", param);
        }
        return usr;
    }

    public void delete(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        namedParameterJdbcTemplate.update("DELETE FROM usr WHERE id = :id", param);
    }
}
