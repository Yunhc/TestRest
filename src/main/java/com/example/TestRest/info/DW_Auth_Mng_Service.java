package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Auth_Mng_Auth_Res_Param;
import com.example.TestRest.info.model.DW_Auth_Mng_User_Res_Param;
import com.example.TestRest.info.model.ReturnMsg;
import com.example.TestRest.info.repository.DW_Auth_Mng_Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DW_Auth_Mng_Service {
	private final DW_Auth_Mng_Repository dw_repository;
	
	public DW_Auth_Mng_Service(DW_Auth_Mng_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}

	//사용자 조회
	public List<DW_Auth_Mng_User_Res_Param> findList(String req_param) {
		return this.dw_repository.findList(req_param);
	}
	
	//사용자 조회
	public List<DW_Auth_Mng_Auth_Res_Param> findAuth(String req_param) {
		return this.dw_repository.findAuth(req_param);
	}
	
	public List<ReturnMsg> saveList(String req_param) {
		log.debug("/saveList = {}", req_param.toString());
		return this.dw_repository.saveList(req_param);
	}
}