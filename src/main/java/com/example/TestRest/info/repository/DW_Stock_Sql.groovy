package com.example.TestRest.info.repository

class DW_Stock_Sql {
	public static String SELECT = """""";
	
	public static STOCK_SELECT_QUERY(String lang, String userid, 
		String werks, String lgort, String status,
		String matnr, String maktx, String mattype, 
		String customer, String date)
	{
		//	ALTER PROC [DBO].[ZZ_USP_STOCK_SEARCH]
		//		@I_LANG					VARCHAR(2),				-- 언어(KR)
		//		@I_USERID           	VARCHAR(20),			-- 사용자아이디
		//		@I_WERKS				VARCHAR(4),				-- 플랜트
		//		@I_LGORT  				VARCHAR(4),				-- 저장위치
		//		@I_STATUS				VARCHAR(1),				-- 상태
		//		@I_MATNR				VARCHAR(30),			-- 자재코드
		//		@I_MAKTX				VARCHAR(100),			-- 자재명
		//		@I_MATTYPE				VARCHAR(1),				-- 자재유형
		//		@I_CUSTOMER				VARCHAR(100),			-- 고객명
		//		@I_DATE					VARCHAR(8)				-- 재고일
		//	AS
	

		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_STOCK_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + werks + """'"""
		SELECT += """, '""" + lgort + """'"""
		SELECT += """, '""" + status + """'"""
		SELECT += """, '""" + matnr + """'"""
		SELECT += """, '""" + maktx + """'"""
		SELECT += """, '""" + mattype + """'"""
		SELECT += """, '""" + customer + """'"""
		SELECT += """, '""" + date + """'"""
	}
}
