package com.example.TestRest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
