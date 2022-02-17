package com.example.TestRest.info.repository;

import java.util.List;

import javax.sql.DataSource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Auth_Mng_User_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Auth_Mng_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager txManager;
    
    @Bean
    public PlatformTransactionManager DW_Auth_Mng_transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    
	public DW_Auth_Mng_Repository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;
		this.txManager = DW_Auth_Mng_transactionManager(dataSource);
	}
	
	//사용자 조회
	public List<DW_Auth_Mng_User_Res_Param> findList(String req_param){
		JSONObject jsonObject = new JSONObject(req_param);
		
		DW_Auth_Mng_Sql.SELECT_QUERY(
			Util.GetData(jsonObject.get("lang")),
			Util.GetData(jsonObject.get("userid")), 
			Util.GetData(jsonObject.get("username"))
		);
		log.debug("findList query = {}", DW_User_Sql.SELECT);

		List<DW_Auth_Mng_User_Res_Param> dw_user = this.jdbcTemplate.query(DW_Auth_Mng_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Auth_Mng_User_Res_Param.class));
		return dw_user;
	}

}
