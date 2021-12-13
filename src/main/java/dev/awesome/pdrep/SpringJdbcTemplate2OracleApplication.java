package dev.awesome.pdrep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dev.awesome.pdrep.model.Cage;

@SpringBootApplication
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public static void main (String[] args) {
//		SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
//	}
	
	@Override
	public void run(String... args) {
//		String sql = "SELECT first_name cage_code, last_name duns_number, emailid status_code FROM dummyuser";
//		
//		List<Cage> cages = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cage.class));
//		
//		cages.forEach(cage -> {
//			System.out.println(cage.toString());
//		});
	}
}
