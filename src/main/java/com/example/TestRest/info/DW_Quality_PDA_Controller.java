package com.example.TestRest.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Req_Param;
import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Res_Param;
import com.example.TestRest.info.model.DW_Return_Message;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DW_Quality_PDA_Controller {
	private DW_Quality_PDA_Service dw_Service;
	
	@Autowired  // spring 4.3 ���� �̻���ʹ� ���� ����
	public DW_Quality_PDA_Controller(DW_Quality_PDA_Service dw_Service) {
		this.dw_Service = dw_Service;
	}

	//ǰ������ ���ó�� ȭ��
	//���ڵ� ���� ��ȸ
	@CrossOrigin("*")
	@PostMapping(value="/dw/quality/pda/barcode_search")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_quality_pda_search(@RequestBody DW_Quality_PDA_Scrap_Req_Param req_param) {
		
		log.debug("/dw/quality/pda/barcode_search");
		log.debug("/dw/quality/pda/barcode_search request = {}", req_param.toString());
		List<DW_Quality_PDA_Scrap_Res_Param> res = dw_Service.search_List(req_param);
		return res;
	}

	//��� ó��
	@CrossOrigin("*")
	@PostMapping(value="/dw/quality/pda/scrap_save")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_quality_pda_scrap_save(@RequestBody DW_Quality_PDA_Scrap_Req_Param req_param) {
		log.debug("/dw/quality/pda/scrap_save");
		log.debug("/dw/quality/pda/scrap_save request = {}", req_param.toString());
		List<DW_Return_Message> res = dw_Service.save_List(req_param);
		return res;
	}
}

