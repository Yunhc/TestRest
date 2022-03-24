package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Req_Param;
import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Quality_PDA_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_Quality_PDA_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//前龙包府 企扁贸府 拳搁
	//官内靛 沥焊 炼雀
	public List<DW_Quality_PDA_Scrap_Res_Param> searchList(DW_Quality_PDA_Scrap_Req_Param req_param){
		
		DW_Quality_PDA_Sql.SELECT_QUERY(req_param );
		log.debug("searchList query = {}", DW_Quality_PDA_Sql.SELECT);
		
		List<DW_Quality_PDA_Scrap_Res_Param> res = this.jdbcTemplate.query(DW_Quality_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Quality_PDA_Scrap_Res_Param.class));
		return res;
	}
	
	//企扁贸府
	public List<DW_Return_Message> saveList(DW_Quality_PDA_Scrap_Req_Param req_param){
		
		DW_Quality_PDA_Sql.SAVE_QUERY(req_param );
		log.debug("saveList query = {}", DW_Quality_PDA_Sql.SELECT);
		
		List<DW_Return_Message> res = this.jdbcTemplate.query(DW_Quality_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Return_Message.class));
		return res;
	}	
}
