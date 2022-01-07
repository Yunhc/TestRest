package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_STC_Req_Param

class DWT_STC_Sql {
	public static String SELECT = """""";
	
	//콤보박스 조회
	public static SELECT_QUERY(DWT_STC_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_STC_PDA_ON_BARCODE_SCAN """
		SELECT += """  '""" + req_param.werks + """'"""
		SELECT += """, '""" + req_param.lgort + """'"""
		SELECT += """, '""" + req_param.barno + """'"""
		SELECT += """, '""" + req_param.qty + """'"""
		SELECT += """, '""" + req_param.loc + """'"""
		SELECT += """, '""" + req_param.userid + """'"""
		SELECT += """, '""" + req_param.force + """'"""
		SELECT += """, '""" + req_param.online + """'"""
	}
}
