package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.model.DW_STC_PDA_Save_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Scan_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Scan_Res_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Search_Req_Param;
import com.example.TestRest.info.model.DW_STC_PDA_Search_Res_Param;
import com.example.TestRest.info.repository.DW_STC_PDA_Repository;


@Service

public class DW_STC_PDA_Service {
	private final DW_STC_PDA_Repository dw_repository;
	
	public DW_STC_PDA_Service(DW_STC_PDA_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//���ǻ� ���� ��ȸ
	public List<DW_STC_PDA_Search_Res_Param> search_List(DW_STC_PDA_Search_Req_Param req_param) {
		return this.dw_repository.searchList(req_param);
	}

	//�¶��� ���ǻ� ���ڵ� ��ĵ
	public List<DW_STC_PDA_Scan_Res_Param> scan_List(DW_STC_PDA_Scan_Req_Param req_param) {
		return this.dw_repository.scanList(req_param);
	}

	//�������� ���ǻ� ����
	public List<DW_Return_Message> save_List(DW_STC_PDA_Save_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}
}
