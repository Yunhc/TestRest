package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Res_Param;
//import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Req_Param;
//import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Res_Param;
import com.example.TestRest.info.repository.DWT_Good_Issue_Repository;

@Service
public class DWT_Good_Issue_Service {
	private final DWT_Good_Issue_Repository dw_repository;
	
	public DWT_Good_Issue_Service(DWT_Good_Issue_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//DO ��ȸ
	public List<DWT_Good_Issue_Res_Param> get_List(DWT_Good_Issue_Req_Param req_param) {
		return this.dw_repository.findList(req_param);
	}

//	//���ڵ� ��ĵ
//	public List<DWT_Good_Issue_Scan_Res_Param> get_List(DWT_Good_Issue_Scan_Req_Param req_param) {
//		return this.dw_repository.BarcodeScan(req_param);
//	}

}
