package com.example.TestRest.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Req_Param;
import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;
import com.example.TestRest.info.repository.DW_Quality_PDA_Repository;


@Service

public class DW_Quality_PDA_Service {
	private final DW_Quality_PDA_Repository dw_repository;
	
	public DW_Quality_PDA_Service(DW_Quality_PDA_Repository dw_repository) {
		this.dw_repository = dw_repository;
	}
	
	//前龙包府 企扁贸府 拳搁
	//官内靛 沥焊 炼雀
	public List<DW_Quality_PDA_Scrap_Res_Param> search_List(DW_Quality_PDA_Scrap_Req_Param req_param) {
		return this.dw_repository.searchList(req_param);
	}

	//企扁贸府
	public List<DW_Return_Message> save_List(DW_Quality_PDA_Scrap_Req_Param req_param) {
		return this.dw_repository.saveList(req_param);
	}
}
