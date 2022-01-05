package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_SelectBox_Search_Req_Param;
import com.example.TestRest.info.model.DW_SelectBox_Search_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_SelectBox_Controller {
	private DW_SelectBox_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_SelectBox_Controller(DW_SelectBox_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	
	@CrossOrigin("*")
	@PostMapping(value="/api/dw/selectboxList")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_selectboxList(@RequestBody DW_SelectBox_Search_Req_Param req_param) {
		log.debug("/api/dw/selectboxList start");
		log.debug("/api/dw/selectboxList request = {}", req_param.toString());
		List<DW_SelectBox_Search_Res_Param> res = dw_Service.get_List(req_param);
		return res;
	}
}
