package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Save_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Save_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DWT_Good_Issue_Cancel_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public DWT_Good_Issue_Cancel_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//취소할 바코드 스캔
	public List<DWT_Good_Issue_Cancel_Scan_Res_Param> scanList(DWT_Good_Issue_Cancel_Scan_Req_Param req_param){
		
		DWT_Good_Issue_Cancel_Sql.SELECT_QUERY(req_param );
		log.debug("findList query = {}", DWT_Good_Issue_Cancel_Sql.SELECT);

		
		List<DWT_Good_Issue_Cancel_Scan_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Cancel_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Cancel_Scan_Res_Param.class));
		return res;
	}

	//스캔한 바코드 출고취소
	public List<DWT_Good_Issue_Cancel_Save_Res_Param> saveList(DWT_Good_Issue_Cancel_Save_Req_Param req_param){
		
		DWT_Good_Issue_Cancel_Sql.SAVE_QUERY(req_param );
		log.debug("findList query = {}", DWT_Good_Issue_Cancel_Sql.SELECT);

		
		List<DWT_Good_Issue_Cancel_Save_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Cancel_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Cancel_Save_Res_Param.class));
		return res;
	}
}
