package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Req_Param;
import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DWT_FG_Receipt_Save_Controller {
	private DWT_FG_Receipt_Save_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DWT_FG_Receipt_Save_Controller(DWT_FG_Receipt_Save_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	
	@CrossOrigin("*")
	@PostMapping(value="/dwt/fg_receipt/save")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_fg_receipt_save_List(@RequestBody DWT_FG_Receipt_Save_Req_Param req_param) {
		log.debug("/dwt/fg_receipt/save");
		log.debug("/dwt/fg_receipt/save request = {}", req_param.toString());
		List<DWT_FG_Receipt_Save_Res_Param> res = dw_Service.get_List(req_param);
		return res;
	}
}
