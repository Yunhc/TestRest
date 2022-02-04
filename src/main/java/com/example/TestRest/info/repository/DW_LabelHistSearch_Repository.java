package com.example.TestRest.info.repository;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_LabelHistSearch_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_LabelHistSearch_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_LabelHistSearch_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//바코드 조회
	public List<DW_LabelHistSearch_Res_Param> search_List(String req_param){
		JSONObject jsonObject = new JSONObject(req_param);
		
		DW_LabelHistSearch_Sql.SELECT_QUERY(
			Util.GetData(jsonObject.get("lang")),
			Util.GetData(jsonObject.get("userid")), 
			Util.GetData(jsonObject.get("werks")), 
			Util.GetData(jsonObject.get("lgort")),
			Util.GetData(jsonObject.get("matnr")),
			Util.GetData(jsonObject.get("maktx")),
			Util.GetData(jsonObject.get("barno")),
			Util.GetData(jsonObject.get("order")),
			Util.GetData(jsonObject.get("stock")), 
			Util.GetData(jsonObject.get("f_date")),
			Util.GetData(jsonObject.get("t_date"))
		);
		
		log.debug("search_List query = {}", DW_LabelHistSearch_Sql.SELECT);

		List<DW_LabelHistSearch_Res_Param> res = this.jdbcTemplate.query(DW_LabelHistSearch_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_LabelHistSearch_Res_Param.class));
		return res;
	}
}
