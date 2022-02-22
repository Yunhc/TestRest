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
import com.example.TestRest.info.model.DW_Auth_Mng_Auth_Res_Param;
import com.example.TestRest.info.model.DW_Auth_Mng_User_Res_Param;
import com.example.TestRest.info.model.ReturnMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Auth_Mng_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager txManager;
    
    @Bean
    public PlatformTransactionManager DW_Auth_Mng_transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    
	public DW_Auth_Mng_Repository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;
		this.txManager = DW_Auth_Mng_transactionManager(dataSource);
	}
	
	//사용자 조회
	public List<DW_Auth_Mng_User_Res_Param> findList(String req_param){
		JSONObject jsonObject = new JSONObject(req_param);
		
		DW_Auth_Mng_Sql.SELECT_QUERY(
			Util.GetData(jsonObject.get("lang")),
			Util.GetData(jsonObject.get("userid")), 
			Util.GetData(jsonObject.get("username"))
		);
		log.debug("findList query = {}", DW_User_Sql.SELECT);

		List<DW_Auth_Mng_User_Res_Param> dw_user = this.jdbcTemplate.query(DW_Auth_Mng_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Auth_Mng_User_Res_Param.class));
		return dw_user;
	}
	
	//권한 조회
	public List<DW_Auth_Mng_Auth_Res_Param> findAuth(String req_param){
		JSONObject jsonObject = new JSONObject(req_param);
		
		DW_Auth_Mng_Sql.SELECT_AUTH_QUERY(
			Util.GetData(jsonObject.get("lang")),
			Util.GetData(jsonObject.get("userid")), 
			Util.GetData(jsonObject.get("procdate"))
		);
		log.debug("findAuth query = {}", DW_User_Sql.SELECT);

		List<DW_Auth_Mng_Auth_Res_Param> dw_user = this.jdbcTemplate.query(DW_Auth_Mng_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Auth_Mng_Auth_Res_Param.class));
		return dw_user;
	}
	
	//권한 저장 
	public List<ReturnMsg> saveList(String req_param){
		DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		td.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		td.setTimeout(10);
		TransactionStatus status = txManager.getTransaction(td);
		
		List<ReturnMsg> return_msg = null;
		
		try {
			JSONObject jsonObject = new JSONObject(req_param);
			log.debug("[upduser] = {}", jsonObject.get("userid"));
			log.debug("[upduser] = {}", jsonObject.get("upduser"));
			log.debug("[upduser] = {}", jsonObject.get("data"));
			
			JSONArray jsonData = jsonObject.getJSONArray("data");
			
			log.debug("[Data Count] = {}", jsonData.length());
			
			for(int i=0; i<jsonData.length(); i++) {
				String strType = "";
				if(i == 0) strType = "S";
				else strType = "E";
				
				JSONObject dtlObject = jsonData.getJSONObject(i);
				log.debug("[userid] = {}", dtlObject.get("progid"));
				
//				public static SAVE_QUERY(String lang, 		String type, 		String userid, 		String progid, 		String findgrant,
//										 String newgrant, 	String savegrant, 	String delgrant, 	String expgrant, 	String prtgrant,
//										 String upduser)
				
				DW_Auth_Mng_Sql.SAVE_QUERY(
					  Util.GetData(jsonObject.get("lang")), 		strType, 									Util.GetData(jsonObject.get("userid")) 		
					, Util.GetData(dtlObject.get("progid")), 		Util.GetData(dtlObject.get("findflag")), 	Util.GetData(dtlObject.get("newflag"))
					, Util.GetData(dtlObject.get("saveflag")), 		Util.GetData(dtlObject.get("delflag")), 	Util.GetData(dtlObject.get("expflag"))
					, Util.GetData(dtlObject.get("prtflag")), 		Util.GetData(jsonObject.get("upduser"))
				);
				
				log.debug("saveList query = {}", DW_Auth_Mng_Sql.SELECT);
				
				return_msg = this.jdbcTemplate.query( DW_Auth_Mng_Sql.SELECT, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
				
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
