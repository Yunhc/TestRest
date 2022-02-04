package com.example.TestRest.info.repository

class DW_LabelHistSearch_Sql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String lang, String userid, String werks, String lgort, String matnr,
		                       String maktx, String barno, String order, String stock, String f_date, String t_date)
	{
//		ALTER PROC [dbo].[ZZ_USP_LABEL_HIST_SEARCH]
//			@I_LANG					VARCHAR(2),				-- 언어(KR)
//		    @I_USERID           	VARCHAR(20),			-- 사용자아이디
//			@I_WERKS				VARCHAR(4),				-- 플랜트
//			@I_LGORT				VARCHAR(4),				-- 저장위치
//			@I_MATNR				VARCHAR(30),			-- 자재코드
//			@I_MAKTX  				VARCHAR(200), 			-- 자재명
//			@I_BARNO				VARCHAR(30),			-- 바코드
//			@I_ORDER				VARCHAR(30),			-- 오더번호
//			@I_STOCK				VARCHAR(1),				-- 재고유무
//			@I_F_DATE				VARCHAR(8),				-- FROM DATE
//			@I_T_DATE				VARCHAR(8)				-- TO DATE
//		
//		AS
		
		SELECT = """""";
		SELECT += """ EXEC ZZ_USP_LABEL_HIST_SEARCH """
		SELECT += """  '""" + lang + """'"""
		SELECT += """, '""" + userid + """'"""
		SELECT += """, '""" + werks + """'"""
		SELECT += """, '""" + lgort + """'"""
		SELECT += """, '""" + matnr + """'"""
		SELECT += """, '""" + maktx + """'"""
		SELECT += """, '""" + barno + """'"""
		SELECT += """, '""" + order + """'"""
		SELECT += """, '""" + stock + """'"""
		SELECT += """, '""" + f_date + """'"""
		SELECT += """, '""" + t_date + """'"""
	}
}
