package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Save_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Save_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Res_Param;
import com.example.TestRest.info.repository.DWT_Good_Issue_Cancel_Repository;


@Service
public class DWT_Good_Issue_Cancel_Service {
	private final DWT_Good_Issue_Cancel_Repository dw_repository;
	
	public DWT_Good_Issue_Cancel_Service(DWT_Good_Issue_Cancel_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}

	//취소할 바코드 스캔
	public List<DWT_Good_Issue_Cancel_Scan_Res_Param> scan_List(DWT_Good_Issue_Cancel_Scan_Req_Param req_param) {
		return this.dw_repository.scanList(req_param);
	}

	//스캔한 바코드 출고 취소
	public List<DWT_Good_Issue_Cancel_Save_Res_Param> save_List(DWT_Good_Issue_Cancel_Save_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}
}
