package com.example.TestRest.info.repository

class DW_UserSql {
	
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
}
