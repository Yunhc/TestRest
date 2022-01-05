package com.example.TestRest.info.repository

import com.example.TestRest.info.model.DW_SelectBox_Search_Req_Param

class DW_SelectBox_Search_Sql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(DW_SelectBox_Search_Req_Param req_param)
	{		
		SELECT = """""";
		SELECT += """ EXEC USP_COMBOBOX_INFO """
		SELECT += """  '""" + req_param.lang + """'"""
		SELECT += """, '""" + req_param.userid + """'"""
		SELECT += """, '""" + req_param.plant + """'"""
		SELECT += """, '""" + req_param.type1 + """'"""
		SELECT += """, '""" + req_param.space + """'"""
	} 
}
