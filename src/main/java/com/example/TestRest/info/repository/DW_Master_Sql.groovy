package com.example.TestRest.info.repository


import com.example.TestRest.info.model.DW_Autolabeller_PDA_Save_Req_Param
import com.example.TestRest.info.model.DW_Master_Company_Save_Req_Param
import com.example.TestRest.info.model.DW_Master_Company_Search_Req_Param
import com.example.TestRest.info.model.DW_Master_Material_Search_Req_Param

class DW_Master_Sql {
	public static String SELECT = """""";
	
	//오토라벨러 생산입고 화면
	//생산오더 정보 조회
	public static COMPANY_SELECT_QUERY(String lang, String i_bukrs, String i_companynm, String i_useflag)
	{
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_MASTER_COMPANY_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + i_bukrs + """'"""		
		SELECT += """, '""" + i_companynm + """'"""
		SELECT += """, '""" + i_useflag + """'"""
	}

	//회사정보 저장 변경 처리
	public static SAVE_QUERY(String lang, 		String type, 	String bukrs, 		String comname		
		, 	String useflag,		String upduser)
	
	{
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_MASTER_COMPANY_SAVE """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + type + """'"""
		SELECT += """, '""" + bukrs + """'"""
		SELECT += """, '""" + comname + """'"""
		SELECT += """, '""" + useflag + """'"""
		SELECT += """, '""" + upduser + """'"""

	}
	
	//자재정보 조회
	public static void MATERIAL_SELECT_QUERY(DW_Master_Material_Search_Req_Param req_param) {
		// TODO Auto-generated method stub
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_MASTER_MATERIAL_SEARCH """
		SELECT += """  '""" + req_param.lang + """'"""
		SELECT += """, '""" + req_param.matnr + """'"""
		SELECT += """, '""" + req_param.maktx + """'"""
		SELECT += """, '""" + req_param.mtart + """'"""
		SELECT += """, '""" + req_param.useflag + """'"""		
	}
	
	//자재정보 저장 변경 처리
	public static MATERIAL_SAVE_QUERY(String lang, 		String type, 	String matnr,	String mtart,	String matkl		
		,String maktx,	String bimst,	String meins,	String grade, 	String useflag,		String upduser)
	
	{
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_MASTER_MATERIAL_SAVE """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + type + """'"""
		SELECT += """, '""" + matnr + """'"""
		SELECT += """, '""" + mtart + """'"""
		SELECT += """, '""" + matkl + """'"""
		SELECT += """, '""" + maktx + """'"""
		SELECT += """, '""" + bimst + """'"""
		SELECT += """, '""" + meins + """'"""
		SELECT += """, '""" + grade + """'"""
		SELECT += """, '""" + useflag + """'"""
		SELECT += """, '""" + upduser + """'"""
	}
}
