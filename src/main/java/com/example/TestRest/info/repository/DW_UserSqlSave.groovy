package com.example.TestRest.info.repository

class DW_UserSqlSave {
	public static String SSQL = """""";
	
	public static SAVE_QUERY( String lang, 		String type, 	String userid, 		String username
							, String plantcd, 	String wccode, 	String warehouse, 	String auth, 		String role
							, String use_role, 	String useflag, String forklift, 	String etc, 		String upduser)
	{
//		ALTER PROC [dbo].[ZZ_USP_USER_SAVE]
//			@I_LANG					VARCHAR(2),				-- 언어(KR)
//			@I_TYPE					VARCHAR(1),				-- S:추가 또는 수정, D:삭제
//			@I_USERID				VARCHAR(20),
//			@I_USERNAME				VARCHAR(50),
//			@I_PLANTCD   			VARCHAR(4),
//			@I_WCCODE    			VARCHAR(4),
//			@I_WAREHOUSE 			VARCHAR(10),
//			@I_AUTH      			VARCHAR(20),
//			@I_ROLE      			VARCHAR(20),
//			@I_USE_ROLE  			VARCHAR(20),
//			@I_USEFLAG   			VARCHAR(1),
//			@I_FORKLIFT  			VARCHAR(20),
//			@I_ETC       			VARCHAR(100),
//			@I_UPDUSER				VARCHAR(20)
//		AS
	
		SSQL = """""";
		SSQL += """ EXEC ZZ_USP_USER_SAVE """
		SSQL += """  '""" + lang + """'"""
		SSQL += """, '""" + type + """'"""
		SSQL += """, '""" + userid + """'"""
		SSQL += """, '""" + username + """'"""
		SSQL += """, '""" + plantcd + """'"""
		SSQL += """, '""" + wccode + """'"""
		SSQL += """, '""" + warehouse + """'"""
		SSQL += """, '""" + auth + """'"""
		SSQL += """, '""" + role + """'"""
		SSQL += """, '""" + use_role + """'"""
		SSQL += """, '""" + useflag + """'"""
		SSQL += """, '""" + forklift + """'"""
		SSQL += """, '""" + etc + """'"""
		SSQL += """, '""" + upduser + """'"""
	} 
}
