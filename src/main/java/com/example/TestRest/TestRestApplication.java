package com.example.TestRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.repository.DW_UserRepository;
import com.example.TestRest.info.repository.DW_UserSql;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
//public class TestRestApplication implements CommandLineRunner {
public class TestRestApplication {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(TestRestApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		String  sql = "select getdate()";
//		
//		List<DW_User> dw_user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DW_User.class));
//		
//		log.debug("findList query = {}", sql);
//	}

}
