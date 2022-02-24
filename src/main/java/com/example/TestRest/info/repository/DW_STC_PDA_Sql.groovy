package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_STC_PDA_Search_Req_Param
import com.example.TestRest.info.model.DW_STC_PDA_Scan_Req_Param

class DW_STC_PDA_Sql {
	public static String SELECT = """""";
	
	//실사정보 조회
	public static SELECT_QUERY(DW_STC_PDA_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_STOCK_COUNT_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_lgort + """'"""
	}

	//스캔 바코드 조회
	public static SCAN_QUERY(DW_STC_PDA_Scan_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_STOCK_COUNT_SCAN """
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
