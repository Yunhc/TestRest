package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DW_STC_PDA_Search_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Search_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.model.DW_STC_PDA_Save_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Scan_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Scan_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_STC_PDA_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_STC_PDA_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//실사정보 조회
	public List<DW_STC_PDA_Search_Res_Param> searchList(DW_STC_PDA_Search_Req_Param req_param){
		
		DW_STC_PDA_Sql.SELECT_QUERY(req_param );
		log.debug("searchList query = {}", DW_STC_PDA_Sql.SELECT);

		
		List<DW_STC_PDA_Search_Res_Param> res = this.jdbcTemplate.query(DW_STC_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_STC_PDA_Search_Res_Param.class));
		return res;
	}

	//스캔 바코드 조회
	public List<DW_STC_PDA_Scan_Res_Param> scanList(DW_STC_PDA_Scan_Req_Param req_param){
		
		DW_STC_PDA_Sql.SCAN_QUERY(req_param );
		log.debug("scanList query = {}", DW_STC_PDA_Sql.SELECT);

		
		List<DW_STC_PDA_Scan_Res_Param> res = this.jdbcTemplate.query(DW_STC_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_STC_PDA_Scan_Res_Param.class));
		return res;
	}
	
	//오프라인 재고실사 저장
	public List<DW_Return_Message> saveList(DW_STC_PDA_Save_Req_Param req_param){
		
		DW_STC_PDA_Sql.SAVE_QUERY(req_param );
		log.debug("saveList query = {}", DW_STC_PDA_Sql.SELECT);

		
		List<DW_Return_Message> res = this.jdbcTemplate.query(DW_STC_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Return_Message.class));
		return res;
	}	
}
