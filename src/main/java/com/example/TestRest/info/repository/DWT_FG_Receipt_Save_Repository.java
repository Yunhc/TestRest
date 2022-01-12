package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Req_Param;
import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DWT_FG_Receipt_Save_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DWT_FG_Receipt_Save_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//콤보 내용 조회
	public List<DWT_FG_Receipt_Save_Res_Param> findList(DWT_FG_Receipt_Save_Req_Param req_param){
		
		DWT_FG_Receipt_Save_Sql.SELECT_QUERY(req_param );
		log.debug("findList query = {}", DWT_FG_Receipt_Save_Sql.SELECT);

		
		List<DWT_FG_Receipt_Save_Res_Param> res = this.jdbcTemplate.query(DWT_FG_Receipt_Save_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_FG_Receipt_Save_Res_Param.class));
		return res;
	}
}
