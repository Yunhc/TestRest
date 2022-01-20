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
import com.example.TestRest.info.model.DW_Login_Res;
import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.model.ReturnMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_User_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager txManager;
    
    
//	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	private final DW_UserRowMapper dw_userRowMapper;
//	private final ReturnMsgRowMapper returnmsgRowMapper;
	
//	public DW_UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//		this.dw_userRowMapper = new DW_UserRowMapper();
//		this.returnmsgRowMapper = new ReturnMsgRowMapper();
//	}
	
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
    
	public DW_User_Repository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;
		this.txManager = transactionManager(dataSource);
	}
	
	//사용자 조회
	public List<DW_Login_Res> loginList(String lang, String userid, String password){
		
		DW_Login_Sql.SELECT_QUERY(lang, userid, password );
		log.debug("loginList query = {}", DW_Login_Sql.SELECT);

		List<DW_Login_Res> dw_login_res = this.jdbcTemplate.query(DW_Login_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Login_Res.class));
		return dw_login_res;
		}
		
	//사용자 조회
	public List<DW_User> findList(String userid, String username, String useflag){
		
		DW_User_Sql.SELECT_QUERY(userid, username, useflag );
		log.debug("findList query = {}", DW_User_Sql.SELECT);

//		return namedParameterJdbcTemplate.query(DW_UserSql.SELECT
//				, EmptySqlParameterSource.INSTANCE
//				, this.dw_userRowMapper);
		
//		List<DW_User> dw_user = namedParameterJdbcTemplate.query(DW_UserSql.SELECT
//				, EmptySqlParameterSource.INSTANCE
//				, this.dw_userRowMapper);
		
		List<DW_User> dw_user = this.jdbcTemplate.query(DW_User_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_User.class));
		return dw_user;
	}
	
	//사용자 추가 삭제 수정 
	public List<ReturnMsg> saveList_old( 
			  String lang, 		String type, 	String userid, 		String username
			, String plantcd, 	String wccode, 	String warehouse, 	String auth, 		String role
			, String use_role, 	String useflag, String forklift, 	String etc, 		String upduser){

		DW_User_Sql.SAVE_QUERY(
				  lang, 		type, 		userid, 	username
				, plantcd, 		wccode, 	warehouse, 	auth, 		role
				, use_role, 	useflag, 	forklift, 	etc, 		upduser);
		
		log.debug("saveList query = {}", DW_User_Sql.SELECT);
		
//		List<ReturnMsg> return_msg = namedParameterJdbcTemplate.query(DW_UserSqlSave.SSQL
//				, EmptySqlParameterSource.INSTANCE
//				, this.returnmsgRowMapper);
		
		//주석 추가 테스트
		
		List<ReturnMsg> return_msg = this.jdbcTemplate.query( DW_User_Sql.SELECT, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
		return return_msg;
	}
	
	//사용자 추가 삭제 수정 
	public List<ReturnMsg> saveList(String req_param){
//		log.debug("saveList = {}", req_param.toString());
		
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
				log.debug("[userid] = {}", dtlObject.get("userid"));
				
				DW_User_Sql.SAVE_QUERY(
					  Util.GetData(jsonObject.getString("lang")), 		Util.GetData(jsonObject.getString("type")), 	Util.GetData(dtlObject.getString("userid")) 		
					, Util.GetData(dtlObject.getString("username")), 	Util.GetData(dtlObject.getString("plantcd")), 	Util.GetData(dtlObject.getString("wccode"))
					, Util.GetData(dtlObject.getString("warehouse")), 	Util.GetData(dtlObject.getString("auth")), 		Util.GetData(dtlObject.getString("role"))
					, Util.GetData(dtlObject.getString("use_role")), 	Util.GetData(dtlObject.getString("useflag")), 	Util.GetData(dtlObject.getString("forklift"))
					, Util.GetData(dtlObject.getString("etc")), 		Util.GetData(jsonObject.getString("upduser"))
				);
				
				log.debug("saveList query = {}", DW_User_Sql.SELECT);
				
				return_msg = this.jdbcTemplate.query( DW_User_Sql.SELECT, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
				
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
