package com.example.TestRest.info.repository


class DW_LoginSql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String lang, String userid, String password)
	{
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_LOGIN_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + password + """'"""
	}
}
