package com.example.TestRest.info.repository;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Stock_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_Stock_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_Stock_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//재고현황 조회
	public List<DW_Stock_Res_Param> stock_search_List(String req_param){
		JSONObject jsonObject = new JSONObject(req_param);
		
		DW_Stock_Sql.STOCK_SELECT_QUERY(
			Util.GetData(jsonObject.get("lang")),
			Util.GetData(jsonObject.get("userid")), 
			Util.GetData(jsonObject.get("werks")), 
			Util.GetData(jsonObject.get("lgort")),
			Util.GetData(jsonObject.get("status")),
			Util.GetData(jsonObject.get("matnr")),
			Util.GetData(jsonObject.get("maktx")),
			Util.GetData(jsonObject.get("mattype")),
			Util.GetData(jsonObject.get("customer")),
			Util.GetData(jsonObject.get("date"))
		);
		
		log.debug("search_List query = {}", DW_Stock_Sql.SELECT);

		List<DW_Stock_Res_Param> res = this.jdbcTemplate.query(DW_Stock_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Stock_Res_Param.class));
		return res;
	}

}
