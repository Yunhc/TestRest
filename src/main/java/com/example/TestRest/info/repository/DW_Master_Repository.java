package com.example.TestRest.info.repository;

import java.util.List;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Master_Company_Search_Res_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Req_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Res_Param;
import com.example.TestRest.info.model.ReturnMsg;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Master_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager txManager;
	

	
	@Bean
    public PlatformTransactionManager DW_Master_transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
	
	public DW_Master_Repository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;
		this.txManager = DW_Master_transactionManager(dataSource);
	}
	
	//회사 마스터 화면
	//회사 마스터 정보 조회
	public List<DW_Master_Company_Search_Res_Param> Company_searchList(String lang, String i_bukrs, String i_companynm, String i_useflag){
		
		DW_Master_Sql.COMPANY_SELECT_QUERY(lang, i_bukrs, i_companynm, i_useflag  );
		log.debug("searchList query = {}", DW_Master_Sql.SELECT);
		
		List<DW_Master_Company_Search_Res_Param> res = this.jdbcTemplate.query(DW_Master_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Master_Company_Search_Res_Param.class));
		return res;
	}
	
	
	//회사 마스터 화면
	//회사 마스터 저장  
	public List<ReturnMsg> Company_saveList(String req_param){
		log.debug("saveList = {}", req_param.toString());
		
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		td.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		td.setTimeout(10);
		TransactionStatus status = txManager.getTransaction(td);
		
		log.debug("saveList -----------------------> 1");
		
		List<ReturnMsg> return_msg = null;
		
		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[upduser] = {}", jsonObject.get("upduser"));
			log.debug("[upduser] = {}", jsonObject.get("data"));
			
			JSONArray jsonData = jsonObject.getJSONArray("data");
			
			
			log.debug("[Data Count] = {}", jsonData.length());
			
			for(int i=0; i<jsonData.length(); i++) {
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[userid] = {}", dtlObject.get("bukrs"));
				log.debug("[wccode] = {}", dtlObject.get("comname"));
				
				DW_Master_Sql.SAVE_QUERY(
					  Util.GetData(jsonObject.get("lang")), 		Util.GetData(jsonObject.get("type")), 		Util.GetData(dtlObject.get("bukrs")) 		
					, Util.GetData(dtlObject.get("comname")), 		Util.GetData(dtlObject.get("useflag")),     Util.GetData(jsonObject.get("upduser"))
				);
				
				log.debug("saveList query = {}", DW_Master_Sql.SELECT);
				
				return_msg = this.jdbcTemplate.query( DW_Master_Sql.SELECT, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
				
				log.debug("[process status] = {}", return_msg.get(0).status);
				if (!return_msg.get(0).status.equals("OK")) {
					log.debug("[process status] = {}", "NG");
					log.debug("[process msg] = {}", return_msg.get(0).msg);
					break;
				}
				else{
					log.debug("[process status] = {}", "OK");
					log.debug("[process msg] = {}", return_msg.get(0).msg);
				}
			}
			
			if (return_msg.get(0).status.equals("OK"))
				txManager.commit(status);
			else
				txManager.rollback(status);
				
		} catch(Exception e) {
			txManager.rollback(status);
		}
		
		return return_msg;
	}
	
	//자재 마스터 화면
	//자재 마스터 정보 조회
	public List<DW_Master_Material_Search_Res_Param> Material_searchList(DW_Master_Material_Search_Req_Param req_param){
		
		DW_Master_Sql.MATERIAL_SELECT_QUERY(req_param );
		log.debug("Material_searchList query = {}", DW_Master_Sql.SELECT);
		
		log.debug("---------------------------------");
		
		List<DW_Master_Material_Search_Res_Param> res = this.jdbcTemplate.query(DW_Master_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Master_Material_Search_Res_Param.class));
		return res;
	}
	
	//자재 마스터 처리
	public List<ReturnMsg> Material_saveList(String req_param){
		
		log.debug("saveList = {}", req_param.toString());
		
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		td.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		td.setTimeout(10);
		TransactionStatus status = txManager.getTransaction(td);
		
		log.debug("saveList -----------------------> 1");
		
		List<ReturnMsg> return_msg = null;
		
		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[upduser] = {}", jsonObject.get("upduser"));
			log.debug("[data] = {}", jsonObject.get("data"));
			
			JSONArray jsonData = jsonObject.getJSONArray("data");
			
			
			log.debug("[Data Count] = {}", jsonData.length());
			
			for(int i=0; i<jsonData.length(); i++) {
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[matnr] = {}", dtlObject.get("matnr"));
				log.debug("[mtart] = {}", dtlObject.get("mtart"));
				log.debug("[matkl] = {}", dtlObject.get("matkl"));
				log.debug("[maktx] = {}", dtlObject.get("maktx"));
				log.debug("[meins] = {}", dtlObject.get("meins"));
				log.debug("[grade] = {}", dtlObject.get("grade"));
				log.debug("[useflag] = {}", dtlObject.get("useflag"));
				log.debug("[bismt] = {}", dtlObject.get("bismt"));
				
				
				
				
				DW_Master_Sql.MATERIAL_SAVE_QUERY(
					  Util.GetData(jsonObject.get("lang")), 		Util.GetData(jsonObject.get("type")), 		Util.GetData(dtlObject.get("matnr")),	
					  Util.GetData(dtlObject.get("mtart")),			Util.GetData(dtlObject.get("matkl")),		Util.GetData(dtlObject.get("maktx")), 		
					  Util.GetData(dtlObject.get("bismt")),         Util.GetData(dtlObject.get("meins")),		Util.GetData(dtlObject.get("grade")),		
					  Util.GetData(dtlObject.get("useflag")),		Util.GetData(jsonObject.get("upduser"))
				);
				
				log.debug("saveList query = {}", DW_Master_Sql.SELECT);
				
				return_msg = this.jdbcTemplate.query( DW_Master_Sql.SELECT, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
				
				log.debug("[process status] = {}", return_msg.get(0).status);
				if (!return_msg.get(0).status.equals("OK")) {
					log.debug("[process status] = {}", "NG");
					log.debug("[process msg] = {}", return_msg.get(0).msg);
					break;
				}
				else{
					log.debug("[process status] = {}", "OK");
					log.debug("[process msg] = {}", return_msg.get(0).msg);
				}
			}
			
			if (return_msg.get(0).status.equals("OK"))
				txManager.commit(status);
			else
				txManager.rollback(status);
				
		} catch(Exception e) {
			txManager.rollback(status);
		}
		
		return return_msg;
		
	}	
	
}
