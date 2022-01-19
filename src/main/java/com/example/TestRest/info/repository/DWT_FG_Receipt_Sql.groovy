package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_FG_Receipt_Req_Param
import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Req_Param

class DWT_FG_Receipt_Sql {
	public static String SELECT = """""";
	
	//바코드 조회
	public static SELECT_QUERY(DWT_FG_Receipt_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_FG_RECEIPT_BARCODE_SCAN """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
	}
	
	//저장
	public static SAVE_QUERY(DWT_FG_Receipt_Save_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_FG_RECEIPT_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
	}
}
