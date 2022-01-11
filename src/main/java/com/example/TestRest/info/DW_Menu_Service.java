package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Menu_Req_Param;
import com.example.TestRest.info.model.DW_Menu_Res_Param;
import com.example.TestRest.info.repository.DW_Menu_Repository;

@Service
public class DW_Menu_Service {
	private final DW_Menu_Repository dw_repository;
	
	public DW_Menu_Service(DW_Menu_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	public List<DW_Menu_Res_Param> get_List(DW_Menu_Req_Param req_param) {
		return this.dw_repository.findList(req_param);
	}
}
