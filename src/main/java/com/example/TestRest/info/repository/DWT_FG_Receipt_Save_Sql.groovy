package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_FG_Receipt_Save_Req_Param

class DWT_FG_Receipt_Save_Sql {
	public static String SELECT = """""";
	
	//콤보박스 조회
	public static SELECT_QUERY(DWT_FG_Receipt_Save_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_FG_RECEIPT_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
	}
}
