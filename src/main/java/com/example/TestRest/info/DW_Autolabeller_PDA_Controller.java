package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Res_Param;
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param;
//import com.example.TestRest.info.model.DW_Return_Message;
//import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_Autolabeller_PDA_Controller {
	private DW_Autolabeller_PDA_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_Autolabeller_PDA_Controller(DW_Autolabeller_PDA_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	//생산오더 정보 조회
	@CrossOrigin("*")
	@PostMapping(value="/dw/autolabeller/pda/search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_autolabeller_pda_search(@RequestBody DW_Autolabeller_PDA_Search_Req_Param req_param) {
		log.debug("/dw/autolabeller/pda/search");
		log.debug("/dw/autolabeller/pda/search request = {}", req_param.toString());
		List<DW_Autolabeller_PDA_Search_Res_Param> res = dw_Service.search_List(req_param);
		return res;
	}
	

	//오프라인 재고실사 저장
//	@CrossOrigin("*")
//	@PostMapping(value="/dw/autolabeller/pda/save")
//	@ResponseStatus(value = HttpStatus.OK)
//	public Object dw_autolabeller_pda_save(@RequestBody DW_Autolabeller_PDA_Save_Req_Param req_param) {
//		log.debug("/dw/autolabeller/pda/save");
//		log.debug("/dw/autolabeller/pda/save request = {}", req_param.toString());
//		List<DW_Return_Message> res = dw_Service.save_List(req_param);
//		return res;
//	}
}

