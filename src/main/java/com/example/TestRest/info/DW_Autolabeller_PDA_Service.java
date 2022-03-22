package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Barcode_Info_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Barcode_Info_Res_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Res_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Res_Param;
import com.example.TestRest.info.repository.DW_Autolabeller_PDA_Repository;


@Service

public class DW_Autolabeller_PDA_Service {
	private final DW_Autolabeller_PDA_Repository dw_repository;
	
	public DW_Autolabeller_PDA_Service(DW_Autolabeller_PDA_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//오토라벨러 생산입고 화면
	//생산오더 정보 조회
	public List<DW_Autolabeller_PDA_Search_Res_Param> search_List(DW_Autolabeller_PDA_Search_Req_Param req_param) {
		return this.dw_repository.searchList(req_param);
	}

	//생산실적 처리
	public List<DW_Return_Message> save_List(DW_Autolabeller_PDA_Save_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}
	
	
	//오토라벨러 Lot 번호 일괄변경 화면
	//바코드 정보 조회 및 Lot번호 변경
	public List<DW_Autolabeller_PDA_Change_Lot_Res_Param> change_List(DW_Autolabeller_PDA_Change_Lot_Req_Param req_param) {
		return this.dw_repository.changeList(req_param);
	}	

	//오토라벨러 바코드 정보조회 화면
	//바코드 정보 조회 및 낱바코드 리스트 조회
	public List<DW_Autolabeller_PDA_Barcode_Info_Res_Param> barcode_List(DW_Autolabeller_PDA_Barcode_Info_Req_Param req_param) {
		return this.dw_repository.barcodeList(req_param);
	}	
}
