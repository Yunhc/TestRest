package com.example.TestRest.info.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.model.ReturnMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository

public class DW_UserRepository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
//	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	private final DW_UserRowMapper dw_userRowMapper;
//	private final ReturnMsgRowMapper returnmsgRowMapper;
	
//	public DW_UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//		this.dw_userRowMapper = new DW_UserRowMapper();
//		this.returnmsgRowMapper = new ReturnMsgRowMapper();
//	}
	
	public DW_UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//사용자 조회
	public List<DW_User> findList(String userid, String username, String useflag){
		
		DW_UserSql.SELECT_QUERY(userid, username, useflag );
		log.debug("findList query = {}", DW_UserSql.SELECT);

//		return namedParameterJdbcTemplate.query(DW_UserSql.SELECT
//				, EmptySqlParameterSource.INSTANCE
//				, this.dw_userRowMapper);
		
//		List<DW_User> dw_user = namedParameterJdbcTemplate.query(DW_UserSql.SELECT
//				, EmptySqlParameterSource.INSTANCE
//				, this.dw_userRowMapper);
		
		List<DW_User> dw_user = this.jdbcTemplate.query(DW_UserSql.SELECT, BeanPropertyRowMapper.newInstance(DW_User.class));
		return dw_user;
	}
	
	//사용자 추가 삭제 수정 
	public List<ReturnMsg> saveList( 
			  String lang, 		String type, 	String userid, 		String username
			, String plantcd, 	String wccode, 	String warehouse, 	String auth, 		String role
			, String use_role, 	String useflag, String forklift, 	String etc, 		String upduser){

		
		DW_UserSqlSave.SAVE_QUERY(
				  lang, 		type, 		userid, 	username
				, plantcd, 		wccode, 	warehouse, 	auth, 		role
				, use_role, 	useflag, 	forklift, 	etc, 		upduser);
		
		log.debug("saveList query = {}", DW_UserSqlSave.SSQL);
		
//		List<ReturnMsg> return_msg = namedParameterJdbcTemplate.query(DW_UserSqlSave.SSQL
//				, EmptySqlParameterSource.INSTANCE
//				, this.returnmsgRowMapper);
		
		
		List<ReturnMsg> return_msg = this.jdbcTemplate.query( DW_UserSqlSave.SSQL, BeanPropertyRowMapper.newInstance(ReturnMsg.class));
		return return_msg;
	}


}
