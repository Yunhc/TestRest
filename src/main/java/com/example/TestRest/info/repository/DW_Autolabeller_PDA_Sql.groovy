package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Req_Param
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param


class DW_Autolabeller_PDA_Sql {
	public static String SELECT = """""";
	
	//오토라벨러 생산입고 화면
	//생산오더 정보 조회
	public static SELECT_QUERY(DW_Autolabeller_PDA_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_AUTOLABELLER_PO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
	}

	//생산실적 처리
	public static SAVE_QUERY(DW_Autolabeller_PDA_Save_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_AUTOLABELLER_PO_SAVE """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks+ """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
		SELECT += """, '""" + req_param.i_grpbarno + """'"""
		SELECT += """, '""" + req_param.i_date_hdf + """'"""
		SELECT += """, '""" + req_param.i_date_fmfm + """'"""
		SELECT += """, '""" + req_param.i_date_prod + """'"""
		SELECT += """, '""" + req_param.i_lotno + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
	}


	//오토라벨러 Lot 번호 일괄변경 화면
	//바코드 정보 조회 및 Lot번호 변경
	public static CHANGE_QUERY(DW_Autolabeller_PDA_Change_Lot_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_AUTOLABELLER_CHANGE_LOT """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_barno + """'"""
		SELECT += """, '""" + req_param.i_lotno + """'"""
		SELECT += """, '""" + req_param.i_calltype + """'"""
	}
}
