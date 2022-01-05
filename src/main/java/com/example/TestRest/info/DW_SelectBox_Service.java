package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_SelectBox_Search_Req_Param;
import com.example.TestRest.info.model.DW_SelectBox_Search_Res_Param;
import com.example.TestRest.info.repository.DW_SelectBox_Repository;


@Service

public class DW_SelectBox_Service {
	private final DW_SelectBox_Repository dw_repository;
	
	public DW_SelectBox_Service(DW_SelectBox_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	public List<DW_SelectBox_Search_Res_Param> get_List(DW_SelectBox_Search_Req_Param req_param) {
		return this.dw_repository.findList(req_param);
	}
}
