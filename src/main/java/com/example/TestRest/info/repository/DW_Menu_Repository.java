package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DW_Menu_Req_Param;
import com.example.TestRest.info.model.DW_Menu_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Menu_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_Menu_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<DW_Menu_Res_Param> findList(DW_Menu_Req_Param req_param){
		
		DW_Menu_Search_Sql.SELECT_QUERY(req_param );
		log.debug("findList query = {}", DW_Menu_Search_Sql.SELECT);

		
		List<DW_Menu_Res_Param> res = this.jdbcTemplate.query(DW_Menu_Search_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Menu_Res_Param.class));
		return res;
	}
}
