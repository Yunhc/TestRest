package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DWT_Good_Issue_Req_Param

class DWT_Good_Issue_Sql {
	public static String SELECT = """""";
	
	//DO Á¶È¸
	public static SELECT_QUERY(DWT_Good_Issue_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC AURUN.BARCODE_AUTEST.DBO.USP_MWMS_GI_DO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_vbeln + """'"""
	}
}
