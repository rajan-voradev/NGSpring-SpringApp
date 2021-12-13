package dev.awesome.pdrep.service;

import dev.awesome.pdrep.model.DummyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DummyUser> getAllDummyUsers() {
		String sql = "SELECT id, first_name, last_name, emailid FROM dummyuser";
		List<DummyUser> dummyUsers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DummyUser.class));
		return dummyUsers;
    }
}
