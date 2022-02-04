package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_LabelHistSearch_Res_Param;
import com.example.TestRest.info.repository.DW_LabelHistSearch_Repository;

@Service
public class DW_LabelHistSearch_Service {
	private final DW_LabelHistSearch_Repository dw_repository;
	
	public DW_LabelHistSearch_Service(DW_LabelHistSearch_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//바코드 이력 조회
	public List<DW_LabelHistSearch_Res_Param> search_List(String req_param) {
		return this.dw_repository.search_List(req_param);
	}
}
