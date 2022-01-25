package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Req_Param

class DWT_Good_Issue_Sql {
	public static String SELECT = """""";
	
	//DO 조회 - DO번호
	public static SELECT_QUERY(DWT_Good_Issue_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
	}
	
	//바코드 스캔
	public static SCAN_QUERY(DWT_Good_Issue_Scan_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_BARCODE_SCAN """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_qty + """'"""
		SELECT += """, '""" + req_param.i_delflag + """'"""
	}

	//DO 조회 - 날짜
	public static SELECT_DO_Date_QUERY(DWT_Good_Issue_DO_Search_Date_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SEARCH_DATE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_date + """'"""
	}
}
