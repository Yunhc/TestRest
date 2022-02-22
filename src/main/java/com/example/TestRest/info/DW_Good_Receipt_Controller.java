package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Res_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param;
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_Good_Receipt_Controller {
	private DW_Good_Receipt_Service dw_Service;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_Good_Receipt_Controller(DW_Good_Receipt_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	//PO 조회 - PO 번호
	@CrossOrigin("*")
	@PostMapping(value="/dw/good_receipt/search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_good_receipt_search(@RequestBody DW_Good_Receipt_Req_Param req_param) {
		log.debug("/dw/good_receipt/search");
		log.debug("/dw/good_receipt/search request = {}", req_param.toString());
		List<DW_Good_Receipt_Res_Param> res = dw_Service.ord_List(req_param);
		return res;
	}

	//PO 상세조회
	@CrossOrigin("*")
	@PostMapping(value="/dw/good_receipt/detail_search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_good_receipt_detail_search(@RequestBody DW_Good_Receipt_Detail_Search_Req_Param req_param) {
		log.debug("/dw/good_receipt/detail_search");
		log.debug("/dw/good_receipt/detail_search request = {}", req_param.toString());
		List<DW_Good_Receipt_Detail_Search_Res_Param> res = dw_Service.detail_List(req_param);
		return res;
	}
	
	//바코드 스캔
	@CrossOrigin("*")
	@PostMapping(value="/dw/good_receipt/scan")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_good_receipt_scan(@RequestBody DW_Good_Receipt_Scan_Req_Param req_param) {
		log.debug("/dw/good_receipt/scan");
		log.debug("/dw/good_receipt/scan request = {}", req_param.toString());
		List<DW_Good_Receipt_Scan_Res_Param> res = dw_Service.scan_List(req_param);
		return res;
	}

	//PO 입고 완료 처리
	@CrossOrigin("*")
	@PostMapping(value="/dw/good_receipt/save")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_good_receipt_save(@RequestBody String req_param) {
		log.debug("/dw/good_receipt/save");
		log.debug("/dw/good_receipt/save = {}", req_param.toString());
		List<DW_Return_Message> res = dw_Service.save_List(req_param);
		return res;
	}	
}
