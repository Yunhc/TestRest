package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Good_Receipt_Save_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Save_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Res_Param;
import com.example.TestRest.info.repository.DW_Good_Receipt_Repository;

@Service
public class DW_Good_Receipt_Service {
	private final DW_Good_Receipt_Repository dw_repository;
	
	public DW_Good_Receipt_Service(DW_Good_Receipt_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//PO ��ȸ - PO ��ȣ
	public List<DW_Good_Receipt_Res_Param> ord_List(DW_Good_Receipt_Req_Param req_param) {
		return this.dw_repository.ordList(req_param);
	}

	//PO ����ȸ
	public List<DW_Good_Receipt_Detail_Search_Res_Param> detail_List(DW_Good_Receipt_Detail_Search_Req_Param req_param) {
		return this.dw_repository.detailList(req_param);
	}
	
	//���ڵ� ��ĵ
	public List<DW_Good_Receipt_Scan_Res_Param> scan_List(DW_Good_Receipt_Scan_Req_Param req_param) {
		return this.dw_repository.scanList(req_param);
	}
	
	//PO �԰� �Ϸ� ó��
	public List<DW_Good_Receipt_Save_Res_Param> save_List(String req_param) {
		return this.dw_repository.saveList(req_param);
	}	
}
