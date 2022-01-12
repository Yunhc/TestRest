package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_FG_Receipt_Req_Param;
import com.example.TestRest.info.model.DWT_FG_Receipt_Res_Param;
import com.example.TestRest.info.repository.DWT_FG_Receipt_Repository;

@Service
public class DWT_FG_Receipt_Service {
	private final DWT_FG_Receipt_Repository dw_repository;
	
	public DWT_FG_Receipt_Service(DWT_FG_Receipt_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	public List<DWT_FG_Receipt_Res_Param> get_List(DWT_FG_Receipt_Req_Param req_param) {
		return this.dw_repository.findList(req_param);
	}
}
