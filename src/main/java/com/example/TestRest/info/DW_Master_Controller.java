package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Master_Company_Search_Res_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Req_Param;
import com.example.TestRest.info.model.DW_Master_Material_Search_Res_Param;
import com.example.TestRest.info.model.ReturnMsg;
import com.example.TestRest.info.model.DW_Master_Company_Search_Req_Param;

import lombok.extern.slf4j.Slf4j;

/**
 * @author User
 *
 */
@Slf4j
@RestController
public class DW_Master_Controller {
	private DW_Master_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_Master_Controller(DW_Master_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	//회사 마스터 화면
	//회사 마스터 정보 조회
	@CrossOrigin("*")
	@PostMapping(value="/dw/master/company/search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_master_company_list_post(@RequestBody DW_Master_Company_Search_Req_Param req_param) {
		
		log.debug("/dw/master/company/search");
		log.debug("/dw/master/company/search request = {}", req_param.toString());
		List<DW_Master_Company_Search_Res_Param> res = dw_Service.search_List(req_param.i_lang, req_param.i_bukrs, req_param.i_companynm, req_param.i_useflag);
		return res;
	}	
	
	//회사 마스터 화면
	//회사 마스터 저장
	@CrossOrigin("*")
	@PostMapping(value="/dw/master/company/save", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_master_company_saveList_post_j(@RequestBody String req_param) {		
		log.debug("/dw/master/company/save");
		List<ReturnMsg> returnMsgList = dw_Service.getDW_Master_Company_SaveList(req_param);
		return returnMsgList;
	}
	
	//자재 마스터 화면
	//자재 마스터 정보 조회
	@CrossOrigin("*")
	@PostMapping(value="/dw/master/Material/search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_master_material_list_post(@RequestBody DW_Master_Material_Search_Req_Param req_param) {		
		log.debug("/dw/master/material/search");
		log.debug("/dw/master/material/search request = {}", req_param.toString());
		List<DW_Master_Material_Search_Res_Param> res = dw_Service.Material_searchList(req_param);
		return res;
	}	
	
	//자재 마스터 화면
	//자재 마스터 저장
	@CrossOrigin("*")
	@PostMapping(value="/dw/master/material/save", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_master_material_saveList_post_j(@RequestBody String req_param) {		
		log.debug("/dw/master/material/save");
		List<ReturnMsg> returnMsgList = dw_Service.getDW_Master_Material_SaveList(req_param);
		return returnMsgList;
	}
	
	
	
}

