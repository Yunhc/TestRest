package com.example.TestRest.info.repository

class DW_Auth_Mng_Sql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String lang, String userid, String username)
	{
//		ALTER PROC [dbo].[ZZ_USP_AUTH_USER_SEARCH]
//			@I_LANG					VARCHAR(2),				-- ���(KR)
//			@I_USERID           	VARCHAR(20),			-- ����ھ��̵�
//			@I_USERNAME				VARCHAR(50)				-- ������̸�
//		AS
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_AUTH_USER_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + username + """'"""
	}
}