package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Res_Param;
import com.example.TestRest.info.repository.DWT_Good_Issue_Cancel_Repository;


@Service
public class DWT_Good_Issue_Cancel_Service {
	private final DWT_Good_Issue_Cancel_Repository dw_repository;
	
	public DWT_Good_Issue_Cancel_Service(DWT_Good_Issue_Cancel_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}

	//¹ÙÄÚµå ½ºÄµ
	public List<DWT_Good_Issue_Cancel_Scan_Res_Param> scan_List(DWT_Good_Issue_Cancel_Scan_Req_Param req_param) {
		return this.dw_repository.scanList(req_param);
	}
}
