package com.example.TestRest.info.repository

class DW_Auth_Mng_Sql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String lang, String userid, String username)
	{
//		ALTER PROC [dbo].[ZZ_USP_AUTH_USER_SEARCH]
//			@I_LANG					VARCHAR(2),				-- 언어(KR)
//			@I_USERID           	VARCHAR(20),			-- 사용자아이디
//			@I_USERNAME				VARCHAR(50)				-- 사용자이름
//		AS
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_AUTH_USER_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + username + """'"""
	}
	
	public static SELECT_AUTH_QUERY(String lang, String userid, String procdate)
	{
//		ALTER PROC [dbo].[ZZ_USP_AUTH_INFO_SEARCH]
//			@I_LANG					VARCHAR(2),				-- 언어(KR)
//		    @I_USERID           	VARCHAR(20),			-- 사용자아이디
//			@I_PROCDATE				VARCHAR(50)				-- 변경날짜
//		AS
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_AUTH_INFO_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + procdate + """'"""
	}
}
