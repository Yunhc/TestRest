package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_Menu_Req_Param

class DW_Menu_Search_Sql {
	public static String SELECT = """""";
	
	//메뉴 조회
	public static SELECT_QUERY(DW_Menu_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_MAIN_MENU_SEARCH """
		SELECT += """  '""" + req_param.lang + """'"""
		SELECT += """, '""" + req_param.userid + """'"""
		SELECT += """, '""" + req_param.menuid + """'"""
		SELECT += """, '""" + req_param.menuname + """'"""
		SELECT += """, '""" + req_param.useflag + """'"""
	}
}
