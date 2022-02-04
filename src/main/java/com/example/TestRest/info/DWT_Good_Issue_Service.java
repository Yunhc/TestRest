package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Bar_Search_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Bar_Search_Res_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Save_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Save_Res_Param;
import com.example.TestRest.info.repository.DWT_Good_Issue_Repository;

@Service
public class DWT_Good_Issue_Service {
	private final DWT_Good_Issue_Repository dw_repository;
	
	public DWT_Good_Issue_Service(DWT_Good_Issue_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//DO ��ȸ - DO ��ȣ
	public List<DWT_Good_Issue_Res_Param> do_List(DWT_Good_Issue_Req_Param req_param) {
		return this.dw_repository.doList(req_param);
	}

	//DO ��ȸ - ��¥
	public List<DWT_Good_Issue_DO_Search_Date_Res_Param> do_date_List(DWT_Good_Issue_DO_Search_Date_Req_Param req_param) {
		return this.dw_repository.dodateList(req_param);
	}
	
	//���ڵ� ��ĵ
	public List<DWT_Good_Issue_Scan_Res_Param> scan_List(String req_param) {
		return this.dw_repository.scanList(req_param);
	}

	//��ĵ ���ڵ� ��ȸ
	public List<DWT_Good_Issue_Bar_Search_Res_Param> bar_List(DWT_Good_Issue_Bar_Search_Req_Param req_param) {
		return this.dw_repository.barList(req_param);
	}
	
	//DO ��� �Ϸ� ó��
	public List<DWT_Good_Issue_DO_Save_Res_Param> save_List(DWT_Good_Issue_DO_Save_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}	
}
