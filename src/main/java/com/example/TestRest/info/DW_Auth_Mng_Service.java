package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Auth_Mng_User_Res_Param;
import com.example.TestRest.info.repository.DW_Auth_Mng_Repository;


@Service
public class DW_Auth_Mng_Service {
	private final DW_Auth_Mng_Repository dw_repository;
	
	public DW_Auth_Mng_Service(DW_Auth_Mng_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}

	//����� ��ȸ
	public List<DW_Auth_Mng_User_Res_Param> findList(String req_param) {
		return this.dw_repository.findList(req_param);
	}
}