package com.example.TestRest.info.repository

class DW_User_Sql {
	
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String userid, String username, String useflag)
	{
//		SELECT = "";
//		SELECT += """ SELECT '' AS SEL""";
//		SELECT += """ ,      USERID """;
//		SELECT += """ ,      USERNAME """;
//		SELECT += """ , 	 USERPWD """;
//		SELECT += """ , 	 USEFLAG """;
//		SELECT += """ FROM   TB_USER """;
//        SELECT += """ WHERE  1 = 1 """;
//		SELECT += """ AND    USERID LIKE '%""" + userid + """%'""";
//		SELECT += """ AND    USERNAME LIKE '%""" + username + """%'""";
//		SELECT += """ AND    USEFLAG LIKE '%""" + useflag + """%'""";
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_USER_SEARCH """
		SELECT += """  '""" + """KR""" + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + username + """'"""
		SELECT += """, '""" + useflag + """'"""
	} 
	
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
	
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_USER_SAVE """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + type + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + username + """'"""
		SELECT += """, '""" + plantcd + """'"""
		SELECT += """, '""" + wccode + """'"""
		SELECT += """, '""" + warehouse + """'"""
		SELECT += """, '""" + auth + """'"""
		SELECT += """, '""" + role + """'"""
		SELECT += """, '""" + use_role + """'"""
		SELECT += """, '""" + useflag + """'"""
		SELECT += """, '""" + forklift + """'"""
		SELECT += """, '""" + etc + """'"""
		SELECT += """, '""" + upduser + """'"""
	}
}
