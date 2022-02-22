package com.example.TestRest.info.repository;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Good_Receipt_Save_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Save_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.model.ReturnMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_Good_Receipt_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public DW_Good_Receipt_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//PO 조회 - PO번호
	public List<DW_Good_Receipt_Res_Param> ordList(DW_Good_Receipt_Req_Param req_param){
		
		DW_Good_Receipt_Sql.SELECT_QUERY(req_param );
		log.debug("ordList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Res_Param.class));
		return res;
	}
	
	
	//PO 상세조회
	public List<DW_Good_Receipt_Detail_Search_Res_Param> detailList(DW_Good_Receipt_Detail_Search_Req_Param req_param){
		
		DW_Good_Receipt_Sql.SELECT_Ord_Detail_QUERY(req_param );
		log.debug("detailList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Detail_Search_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Detail_Search_Res_Param.class));
		return res;
	}


	//바코드 스캔
	public List<DW_Good_Receipt_Scan_Res_Param> scanList(DW_Good_Receipt_Scan_Req_Param req_param){
		
		DW_Good_Receipt_Sql.SCAN_QUERY(req_param );
		log.debug("scanList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Scan_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Scan_Res_Param.class));
		return res;
	}


	//PO 입고 처리
	public List<DW_Return_Message> saveList(DW_Good_Receipt_Save_Req_Param req_param){
		
		DW_Good_Receipt_Sql.SELECT_Ord_Save_QUERY(req_param );
		log.debug("saveList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Return_Message> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Return_Message.class));
		return res;
	}
}
