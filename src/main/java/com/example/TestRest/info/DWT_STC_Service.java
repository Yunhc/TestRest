package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_STC_Req_Param;
import com.example.TestRest.info.model.DWT_STC_Res_Param;
import com.example.TestRest.info.repository.DWT_STC_Repository;

@Service

public class DWT_STC_Service {
	private final DWT_STC_Repository dw_repository;
	
	public DWT_STC_Service(DWT_STC_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	public List<DWT_STC_Res_Param> get_List(DWT_STC_Req_Param req_param) {
		return this.dw_repository.findList(req_param);
	}
}
