package com.example.TestRest.info.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Res_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DW_Autolabeller_PDA_Repository {
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public DW_Autolabeller_PDA_Repository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//����󺧷� �����԰� ȭ��
	//������� ���� ��ȸ
	public List<DW_Autolabeller_PDA_Search_Res_Param> searchList(DW_Autolabeller_PDA_Search_Req_Param req_param){
		
		DW_Autolabeller_PDA_Sql.SELECT_QUERY(req_param );
		log.debug("searchList query = {}", DW_Autolabeller_PDA_Sql.SELECT);
		
		List<DW_Autolabeller_PDA_Search_Res_Param> res = this.jdbcTemplate.query(DW_Autolabeller_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Autolabeller_PDA_Search_Res_Param.class));
		return res;
	}
	
	//������� ó��
	public List<DW_Return_Message> saveList(DW_Autolabeller_PDA_Save_Req_Param req_param){
		
		DW_Autolabeller_PDA_Sql.SAVE_QUERY(req_param );
		log.debug("saveList query = {}", DW_Autolabeller_PDA_Sql.SELECT);
		
		List<DW_Return_Message> res = this.jdbcTemplate.query(DW_Autolabeller_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Return_Message.class));
		return res;
	}	

	
	//����󺧷� Lot ��ȣ �ϰ����� ȭ��
	//���ڵ� ���� ��ȸ �� Lot��ȣ ����
	public List<DW_Autolabeller_PDA_Change_Lot_Res_Param> changeList(DW_Autolabeller_PDA_Change_Lot_Req_Param req_param){
		
		DW_Autolabeller_PDA_Sql.CHANGE_QUERY(req_param );
		log.debug("changeList query = {}", DW_Autolabeller_PDA_Sql.SELECT);

		List<DW_Autolabeller_PDA_Change_Lot_Res_Param> res = this.jdbcTemplate.query(DW_Autolabeller_PDA_Sql.SELECT, BeanPropertyRowMapper.newInstance(DW_Autolabeller_PDA_Change_Lot_Res_Param.class));
		return res;
	}	
}
