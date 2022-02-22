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
	
	public static SAVE_QUERY(String lang, 		String type, 		String userid, 		String progid, 		String findgrant,
							 String newgrant, 	String savegrant, 	String delgrant, 	String expgrant, 	String prtgrant,
							 String upduser)
	{
//		ALTER PROC [dbo].[ZZ_USP_AUTH_INFO_SAVE]
//			@I_LANG					VARCHAR(2),				-- 언어(KR)
//			@I_TYPE					VARCHAR(1),				-- S:시작, E:그외 데이터
//			@I_USERID				VARCHAR(20),	
//			@I_PROGID				VARCHAR(20),			-- 프로그램ID 
//			@I_FINDGRANT			VARCHAR(2),
//			@I_NEWGRANT 			VARCHAR(2),
//			@I_SAVEGRANT			VARCHAR(2),
//			@I_DELGRANT 			VARCHAR(2),
//			@I_EXPGRANT 			VARCHAR(2),
//			@I_PRTGRANT 			VARCHAR(2),
//			@I_UPDUSER				VARCHAR(20)
//		AS
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_AUTH_INFO_SAVE """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + type + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + progid + """'"""
		SELECT += """, '""" + findgrant + """'"""
		SELECT += """, '""" + newgrant + """'"""
		SELECT += """, '""" + savegrant + """'"""
		SELECT += """, '""" + delgrant + """'"""
		SELECT += """, '""" + expgrant + """'"""
		SELECT += """, '""" + prtgrant + """'"""
		SELECT += """, '""" + upduser + """'"""
	}
}
