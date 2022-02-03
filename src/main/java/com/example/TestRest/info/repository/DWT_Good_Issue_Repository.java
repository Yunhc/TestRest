package com.example.TestRest.info.repository;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Res_Param;
//import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Res_Param;
import com.example.TestRest.Util;
import com.example.TestRest.info.model.DWT_Good_Issue_Bar_Search_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Bar_Search_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DWT_Good_Issue_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager txManager;
	
	public DWT_Good_Issue_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//DO 조회 - DO번호
	public List<DWT_Good_Issue_Res_Param> doList(DWT_Good_Issue_Req_Param req_param){
		
		DWT_Good_Issue_Sql.SELECT_QUERY(req_param );
		log.debug("doList query = {}", DWT_Good_Issue_Sql.SELECT);

		List<DWT_Good_Issue_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Res_Param.class));
		return res;
	}

	//바코드 스캔
//	public List<DWT_Good_Issue_Scan_Res_Param> scanList(DWT_Good_Issue_Scan_Req_Param req_param){
//		
//		DWT_Good_Issue_Sql.SCAN_QUERY(req_param );
//		log.debug("scanList query = {}", DWT_Good_Issue_Sql.SELECT);
//
//		List<DWT_Good_Issue_Scan_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Scan_Res_Param.class));
//		return res;
//	}

	public List<DWT_Good_Issue_Scan_Res_Param> scanList(String req_param){
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		td.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		td.setTimeout(10);
		TransactionStatus status = txManager.getTransaction(td);
		
		log.debug("scanList -----------------------> 1");
		
		List<DWT_Good_Issue_Scan_Res_Param> res = null;
		
		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[vbeln] = {}", jsonObject.get("i_vbeln"));
			log.debug("[data] = {}", jsonObject.get("data"));
			
			JSONArray jsonData = jsonObject.getJSONArray("data");
			
			
			log.debug("[Data Count] = {}", jsonData.length());
			
			String strBarno = "";
			
			for(int i=0; i<jsonData.length(); i++) {
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[barno] = {}", dtlObject.get("i_barno"));
				
				if (!strBarno.equals(Util.GetData(dtlObject.get("i_barno")))){
					DWT_Good_Issue_Sql.SCAN_QUERY(
						  Util.GetData(jsonObject.get("i_lang")), 	Util.GetData(jsonObject.get("i_userid")),	Util.GetData(jsonObject.get("i_werks")) 		
						, Util.GetData(jsonObject.get("i_vbeln")), 	Util.GetData(dtlObject.get("i_barno")), 	Util.GetData(jsonObject.get("i_qty"))
						, Util.GetData(jsonObject.get("i_delflag")), 	Util.GetData(jsonObject.get("i_calltype"))
					);
					
					log.debug("scanList query = {}", DWT_Good_Issue_Sql.SELECT);
					
					res = this.jdbcTemplate.query( DWT_Good_Issue_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Scan_Res_Param.class));
					
					log.debug("[process status] = {}", res.get(0).code);
					if (res.get(0).code.equals("NG")) {
						log.debug("[process status] = {}", "NG");
						log.debug("[process message] = {}", res.get(0).message);
						break;
					}
					else{
						log.debug("[process status] = {}", "OK");
						log.debug("[process msg] = {}", res.get(0).barno);
					}					
				}
				
				strBarno = Util.GetData(dtlObject.get("i_barno"));
			}
			
			if (!res.get(0).code.equals("NG"))
				txManager.commit(status);
			else
				txManager.rollback(status);
		} catch(Exception e) {
			txManager.rollback(status);
		}
		
		return res;
	}
	
	//DO 조회 - 날짜
	public List<DWT_Good_Issue_DO_Search_Date_Res_Param> dodateList(DWT_Good_Issue_DO_Search_Date_Req_Param req_param){
		
		DWT_Good_Issue_Sql.SELECT_DO_Date_QUERY(req_param );
		log.debug("dodateList query = {}", DWT_Good_Issue_Sql.SELECT);

		List<DWT_Good_Issue_DO_Search_Date_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_DO_Search_Date_Res_Param.class));
		return res;
	}

	//스캔 바코드 조회
	public List<DWT_Good_Issue_Bar_Search_Res_Param> barList(DWT_Good_Issue_Bar_Search_Req_Param req_param){
		
		DWT_Good_Issue_Sql.SELECT_Bar_QUERY(req_param );
		log.debug("barList query = {}", DWT_Good_Issue_Sql.SELECT);

		List<DWT_Good_Issue_Bar_Search_Res_Param> res = this.jdbcTemplate.query(DWT_Good_Issue_Sql.SELECT, BeanPropertyRowMapper.newInstance(DWT_Good_Issue_Bar_Search_Res_Param.class));
		return res;
	}
}
