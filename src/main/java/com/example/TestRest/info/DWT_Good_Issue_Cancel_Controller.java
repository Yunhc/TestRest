package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Req_Param;
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Res_Param;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DWT_Good_Issue_Cancel_Controller {
	private DWT_Good_Issue_Cancel_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DWT_Good_Issue_Cancel_Controller(DWT_Good_Issue_Cancel_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	@CrossOrigin("*")
	@PostMapping(value="/dwt/good_issue_cancel/scan")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dwt_good_issue_cancel_scan(@RequestBody DWT_Good_Issue_Cancel_Scan_Req_Param req_param) {
		log.debug("/dwt/good_issue_cancel/scan");
		log.debug("/dwt/good_issue_cancel/scan request = {}", req_param.toString());
		List<DWT_Good_Issue_Cancel_Scan_Res_Param> res = dw_Service.scan_List(req_param);
		return res;
	}
}
