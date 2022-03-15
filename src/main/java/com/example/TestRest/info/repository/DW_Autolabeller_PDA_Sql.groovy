package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Autolabeller_PDA_Search_Req_Param
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Change_Lot_Req_Param
import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param


class DW_Autolabeller_PDA_Sql {
	public static String SELECT = """""";
	
	//����󺧷� �����԰� ȭ��
	//������� ���� ��ȸ
	public static SELECT_QUERY(DW_Autolabeller_PDA_Search_Req_Param req_param)
	{
		SELECT = """""";
		SELECT += """ EXEC USP_MWMS2_AUTOLABELLER_PO_SEARCH """
		SELECT += """  '""" + req_param.i_lang + """'"""
		SELECT += """, '""" + req_param.i_werks + """'"""
		SELECT += """, '""" + req_param.i_userid + """'"""
		SELECT += """, '""" + req_param.i_ord_no + """'"""
	}

	//������� ó��
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


	//����󺧷� Lot ��ȣ �ϰ����� ȭ��
	//���ڵ� ���� ��ȸ �� Lot��ȣ ����
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
