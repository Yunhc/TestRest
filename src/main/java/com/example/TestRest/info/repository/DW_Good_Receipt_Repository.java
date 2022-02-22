package com.example.TestRest.info.repository;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Good_Receipt_Save_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_Good_Receipt_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public DW_Good_Receipt_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//PO ��ȸ - PO��ȣ
	public List<DW_Good_Receipt_Res_Param> ordList(DW_Good_Receipt_Req_Param req_param){

		DW_Good_Receipt_Sql.SELECT_QUERY(req_param );
		log.debug("ordList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Res_Param.class));
		return res;
	}


	//PO ����ȸ
	public List<DW_Good_Receipt_Detail_Search_Res_Param> detailList(DW_Good_Receipt_Detail_Search_Req_Param req_param){

		DW_Good_Receipt_Sql.SELECT_Ord_Detail_QUERY(req_param );
		log.debug("detailList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Detail_Search_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Detail_Search_Res_Param.class));
		return res;
	}


	//���ڵ� ��ĵ
	public List<DW_Good_Receipt_Scan_Res_Param> scanList(DW_Good_Receipt_Scan_Req_Param req_param){

		DW_Good_Receipt_Sql.SCAN_QUERY(req_param );
		log.debug("scanList query = {}", DW_Good_Receipt_Sql.SELECT);

		List<DW_Good_Receipt_Scan_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Scan_Res_Param.class));
		return res;
	}


	//PO �԰� ó��
	public List<DW_Good_Receipt_Save_Res_Param> saveList(String req_param){

//		DW_Good_Receipt_Sql.SELECT_Ord_Save_QUERY(req_param);
//		log.debug("saveList query = {}", DW_Good_Receipt_Sql.SELECT);
//
//		List<DW_Good_Receipt_Save_Res_Param> res = this.jdbcTemplate.query(DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Save_Res_Param.class));
//		return res;

		List<DW_Good_Receipt_Save_Res_Param> res = null;

		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[data] = {}", jsonObject.get("data"));

			JSONArray jsonData = jsonObject.getJSONArray("data");
			log.debug("[Data Count] = {}", jsonData.length());

			String strEndofline = "N";

			for(int i=0; i<jsonData.length(); i++) {
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[barno] = {}", dtlObject.get("barno"));

				if (i == jsonData.length()-1) {
					strEndofline = "Y";
				}

				DW_Good_Receipt_Sql.SELECT_Ord_Save_QUERY(
					  Util.GetData(jsonObject.get("i_lang")), Util.GetData(jsonObject.get("i_werks")), Util.GetData(jsonObject.get("i_userid"))
					, Util.GetData(dtlObject.get("ebeln")), Util.GetData(dtlObject.get("ebelp")), Util.GetData(dtlObject.get("barno"))
					, Util.GetData(dtlObject.get("matnr")), Util.GetData(dtlObject.get("qty")), Util.GetData(jsonObject.get("i_device")), Util.GetData(jsonObject.get("i_ipaddress"))
					, Util.GetData(jsonObject.get("i_model")), Util.GetData(jsonObject.get("i_osversion")), strEndofline
				);

				log.debug("saveList query = {}", DW_Good_Receipt_Sql.SELECT);

				res = this.jdbcTemplate.query( DW_Good_Receipt_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Good_Receipt_Save_Res_Param.class));

				log.debug("[process status] = {}", res.get(0).code);

				if (res.get(0).code == null) {
					log.debug("[process status] = {}", "OK");
					log.debug("[process msg] = {}", res.get(0).message);
				}
				else{
					log.debug("[process status] = {}", "NG");
					log.debug("[process message] = {}", res.get(0).message);
					break;
				}

			}

//			if (!res.get(0).code.equals("NG"))
//				txManager.commit(status);
//			else
//				txManager.rollback(status);
		} catch(Exception e) {
//			txManager.rollback(status);
		}

		return res;

	}
}
