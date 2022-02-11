package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Save_Req_Param
import com.example.TestRest.info.model.DWT_Good_Issue_Cancel_Scan_Req_Param

class DWT_Good_Issue_Cancel_Sql {
	public static String SELECT = """""";

	
	//����� ���ڵ� ��ĵ
	public static SELECT_QUERY(DWT_Good_Issue_Cancel_Scan_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_CANCEL_BAR_SCAN """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_matnr + """'"""
		SELECT += """, '""" + req_param.i_proctype + """'"""
		SELECT += """, '""" + req_param.i_calltype + """'"""
	}
	
	//��ĵ�� ���ڵ� ������
	public static SAVE_QUERY(DWT_Good_Issue_Cancel_Save_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_CANCEL_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
		SELECT += """, '""" + req_param.i_matnr + """'"""
	}
}
