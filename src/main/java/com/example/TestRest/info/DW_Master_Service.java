package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Master_Company_Search_Res_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Req_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Res_Param;
import com.example.TestRest.info.model.ReturnMsg;
import com.example.TestRest.info.repository.DW_Master_Repository;


@Service

public class DW_Master_Service {
	private final DW_Master_Repository dw_master_repository;
	
	public DW_Master_Service(DW_Master_Repository dw_repository) {
		this.dw_master_repository = dw_repository;
	}
	
	//ȸ�� ������ ȭ��
	//ȸ�� ������ ���� ��ȸ
	public List<DW_Master_Company_Search_Res_Param> search_List(String lang, String i_bukrs, String i_companynm, String i_useflag) {
		return this.dw_master_repository.Company_searchList(lang, i_bukrs, i_companynm, i_useflag );
	}
	
	//ȸ�� ������ ȭ��
	//ȸ�� ������ ���� 
	public List<ReturnMsg> getDW_Master_Company_SaveList(String req_param) {
		return this.dw_master_repository.Company_saveList(req_param);
	}
	
	//���� ������ ȭ��
	//���� ������ ���� ��ȸ
	public List<DW_Master_Material_Search_Res_Param> Material_searchList(DW_Master_Material_Search_Req_Param req_param) {		
		return this.dw_master_repository.Material_searchList(req_param);
	}
	
	//���� ������ ȭ��
	//���� ������ ���� 
	public List<ReturnMsg> getDW_Master_Material_SaveList(String req_param) {
		return this.dw_master_repository.Material_saveList(req_param);
	}

}
