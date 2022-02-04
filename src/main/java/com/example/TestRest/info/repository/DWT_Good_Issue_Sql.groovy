package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_Scan_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Search_Date_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_Bar_Search_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_DO_Save_Req_Param

class DWT_Good_Issue_Sql {
	public static String SELECT = """""";
	
	//DO ��ȸ - DO��ȣ
	public static SELECT_QUERY(DWT_Good_Issue_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
	}
	
	//���ڵ� ��ĵ
	public static SCAN_QUERY(String i_lang, String i_userid, 	String i_werks, 	String i_vbeln
		, String i_barno, 	String i_qty, 	String i_delflag, 	String i_calltype)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_BARCODE_SCAN """
		SELECT += """  '""" + i_lang + """'"""
		SELECT += """, '""" + i_userid + """'"""
		SELECT += """, '""" + i_werks + """'"""
		SELECT += """, '""" + i_vbeln + """'"""
		SELECT += """, '""" + i_barno + """'"""
		SELECT += """, '""" + i_qty + """'"""
		SELECT += """, '""" + i_delflag + """'"""
		SELECT += """, '""" + i_calltype + """'"""
	}

	//DO ��ȸ - ��¥
	public static SELECT_DO_Date_QUERY(DWT_Good_Issue_DO_Search_Date_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SEARCH_DATE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_date + """'"""
	}
	
	//��ĵ ���ڵ� ��ȸ
	public static SELECT_Bar_QUERY(DWT_Good_Issue_Bar_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_BAR_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
	}

	//DO ��� ó��
	public static SELECT_DO_Save_QUERY(DWT_Good_Issue_DO_Save_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_procflag + """'"""
	}
}
