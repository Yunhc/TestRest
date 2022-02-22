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
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
		SELECT += """, '""" + req_param.i_ord_item_no + """'"""
	}
	
	//바코드 스캔
	public static SCAN_QUERY(DW_Good_Receipt_Scan_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_BARCODE_SCAN """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
		SELECT += """, '""" + req_param.i_ord_item_no + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
	}

	//PO 입고 처리
	public static SELECT_Ord_Save_QUERY(String i_lang, String i_werks, String i_userid, String i_ord_no, String i_ord_seq,
		String i_barno, String i_matnr, String i_qty, String i_device, String i_ipaddress, String i_model, String i_osversion, String i_endlineyn)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS_MMPO_GR_SAVE """
		SELECT += """  '""" + i_lang + """'"""
		SELECT += """, '""" + i_werks + """'"""
		SELECT += """, '""" + i_userid + """'"""
		SELECT += """, '""" + i_ord_no + """'"""
		SELECT += """, '""" + i_ord_seq + """'"""
		SELECT += """, '""" + i_barno + """'"""
		SELECT += """, '""" + i_matnr + """'"""
		SELECT += """, '""" + i_qty + """'"""
		SELECT += """, '""" + i_device + """'"""
		SELECT += """, '""" + i_ipaddress + """'"""
		SELECT += """, '""" + i_model + """'"""
		SELECT += """, '""" + i_osversion + """'"""
		SELECT += """, '""" + i_endlineyn + """'"""
	}
}
