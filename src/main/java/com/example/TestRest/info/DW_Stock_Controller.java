package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Stock_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_Stock_Controller {
	private DW_Stock_Service dw_Service;
	
	@Autowired  // spring 4.3 ���� �̻���ʹ� ���� ����
	public DW_Stock_Controller(DW_Stock_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	@CrossOrigin("*")
	@PostMapping(value="/dw_stock_search_p_j", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_stock_search_post_j(@RequestBody String req_param) {		
//		log.debug("/dw_stock_search_p_j = {}", req_param.toString());
		List<DW_Stock_Res_Param> res = dw_Service.stock_search_List(req_param);
		
		log.debug("/dw_stock_search_p_j res = {}", res.toString());
		return res;
	}

}