package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Stock_Res_Param;
import com.example.TestRest.info.repository.DW_Stock_Repository;

@Service
public class DW_Stock_Service {
	private final DW_Stock_Repository dw_repository;
	
	public DW_Stock_Service(DW_Stock_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//재고현황 조회
	public List<DW_Stock_Res_Param> stock_search_List(String req_param) {
		return this.dw_repository.stock_search_List(req_param);
	}

}
