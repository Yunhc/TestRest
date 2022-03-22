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
	
	//����󺧷� �����԰� ȭ��
	//������� ���� ��ȸ
	public List<DW_Autolabeller_PDA_Search_Res_Param> search_List(DW_Autolabeller_PDA_Search_Req_Param req_param) {
		return this.dw_repository.searchList(req_param);
	}

	//������� ó��
	public List<DW_Return_Message> save_List(DW_Autolabeller_PDA_Save_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}
	
	
	//����󺧷� Lot ��ȣ �ϰ����� ȭ��
	//���ڵ� ���� ��ȸ �� Lot��ȣ ����
	public List<DW_Autolabeller_PDA_Change_Lot_Res_Param> change_List(DW_Autolabeller_PDA_Change_Lot_Req_Param req_param) {
		return this.dw_repository.changeList(req_param);
	}	

	//����󺧷� ���ڵ� ������ȸ ȭ��
	//���ڵ� ���� ��ȸ �� �����ڵ� ����Ʈ ��ȸ
	public List<DW_Autolabeller_PDA_Barcode_Info_Res_Param> barcode_List(DW_Autolabeller_PDA_Barcode_Info_Req_Param req_param) {
		return this.dw_repository.barcodeList(req_param);
	}	
}
