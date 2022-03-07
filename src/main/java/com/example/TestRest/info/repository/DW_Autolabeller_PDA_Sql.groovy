package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param
//import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param


class DW_Autolabeller_PDA_Sql {
	public static String SELECT = """""";
	
	//실사정보 조회
	public static SELECT_QUERY(DW_Autolabeller_PDA_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_AUTOLABELLER_PO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
	}


	//오프라인 재고실사 저장
//	public static SAVE_QUERY(DW_Autolabeller_PDA_Save_Req_Param req_param)
//	{
//		SELECT = """""";
//		SELECT += """ EXEC USP_MWMS2_STOCK_COUNT_SAVE """
//		SELECT += """  '""" + req_param.i_lang + """'"""
//		SELECT += """, '""" + req_param.i_werks+ """'"""
//		SELECT += """, '""" + req_param.i_userid + """'"""
//		SELECT += """, '""" + req_param.i_lgort + """'"""
//		SELECT += """, '""" + req_param.i_barno + """'"""
//		SELECT += """, '""" + req_param.i_qty + """'"""
//		SELECT += """, '""" + req_param.i_loc + """'"""
//		SELECT += """, '""" + req_param.i_packtype + """'"""
//		SELECT += """, '""" + req_param.i_area + """'"""
//	}
}
