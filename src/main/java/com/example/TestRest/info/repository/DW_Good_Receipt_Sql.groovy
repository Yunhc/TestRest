package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Good_Receipt_Detail_Search_Req_Param
import com.example.TestRest.info.model.DW_Good_Receipt_Req_Param
import com.example.TestRest.info.model.DW_Good_Receipt_Save_Req_Param
import com.example.TestRest.info.model.DW_Good_Receipt_Scan_Req_Param

class DW_Good_Receipt_Sql {
	public static String SELECT = """""";
	
	//PO 조회 - PO번호
	public static SELECT_QUERY(DW_Good_Receipt_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_ORD_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
		SELECT += """, '""" + req_param.i_ord_item_no + """'"""
		SELECT += """, '""" + req_param.i_date_from + """'"""
		SELECT += """, '""" + req_param.i_date_to + """'"""
	}

	//PO 상세조회
	public static SELECT_Ord_Detail_QUERY(DW_Good_Receipt_Detail_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_ORD_DETAIL_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_date + """'"""
	}
	
	//바코드 스캔
	public static SCAN_QUERY(DW_Good_Receipt_Scan_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_BARCODE_SCAN """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_qty + """'"""
		SELECT += """, '""" + req_param.i_delflag + """'"""
		SELECT += """, '""" + req_param.i_calltype + """'"""
	}

	//PO 입고 처리
	public static SELECT_Ord_Save_QUERY(DW_Good_Receipt_Save_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_procflag + """'"""
	}
}
