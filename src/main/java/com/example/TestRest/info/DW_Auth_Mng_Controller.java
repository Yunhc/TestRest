package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Auth_Mng_Auth_Res_Param;
import com.example.TestRest.info.model.DW_Auth_Mng_User_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_Auth_Mng_Controller {
	private DW_Auth_Mng_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_Auth_Mng_Controller(DW_Auth_Mng_Service dw_Service) {
		this.dw_Service = dw_Service;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/dw_auth_mng_user_search_p_j", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_auth_mng_user_search_post_j(@RequestBody String req_param) {		

		log.debug("/dw_label_hist_search_post_j = {}", req_param.toString());
		List<DW_Auth_Mng_User_Res_Param> res = dw_Service.findList(req_param);
		return res;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/dw_auth_mng_auth_search_p_j", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_auth_mng_auth_search_post_j(@RequestBody String req_param) {		

		log.debug("/dw_label_hist_search_post_j = {}", req_param.toString());
		List<DW_Auth_Mng_Auth_Res_Param> res = dw_Service.findAuth(req_param);
		return res;
	}

}
