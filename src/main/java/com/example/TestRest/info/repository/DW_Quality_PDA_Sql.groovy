package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Quality_PDA_Scrap_Req_Param

class DW_Quality_PDA_Sql {
	public static String SELECT = """""";
	
	//前龙包府 企扁贸府 拳搁
	//官内靛 沥焊 炼雀
	public static SELECT_QUERY(DW_Quality_PDA_Scrap_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_QUALITY_BARCODE_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_calltype + """'"""
	}

	//企扁贸府
	public static SAVE_QUERY(DW_Quality_PDA_Scrap_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_QUALITY_SCRAP_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_calltype + """'"""
	}
}
