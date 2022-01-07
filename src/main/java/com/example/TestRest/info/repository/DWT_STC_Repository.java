package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DWT_STC_Req_Param;
import com.example.TestRest.info.model.DWT_STC_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DWT_STC_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DWT_STC_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//콤보 내용 조회
	public List<DWT_STC_Res_Param> findList(DWT_STC_Req_Param req_param){
		
		DWT_STC_Sql.SELECT_QUERY(req_param );
		log.debug("findList query = {}", DWT_STC_Sql.SELECT);

		
		List<DWT_STC_Res_Param> res = this.jdbcTemplate.query(DWT_STC_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_STC_Res_Param.class));
		return res;
	}
}
