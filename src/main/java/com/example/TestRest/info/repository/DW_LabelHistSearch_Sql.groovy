package com.example.TestRest.info.repository

class DW_LabelHistSearch_Sql {
	public static String SELECT = """""";
	
	public static SELECT_QUERY(String lang, String userid, String werks, String lgort, String matnr,
		                       String maktx, String barno, String order, String stock, String f_date, String t_date)
	{
//		ALTER PROC [dbo].[ZZ_USP_LABEL_HIST_SEARCH]
//			@I_LANG					VARCHAR(2),				-- ���(KR)
//		    @I_USERID           	VARCHAR(20),			-- ����ھ��̵�
//			@I_WERKS				VARCHAR(4),				-- �÷�Ʈ
//			@I_LGORT				VARCHAR(4),				-- ������ġ
//			@I_MATNR				VARCHAR(30),			-- �����ڵ�
//			@I_MAKTX  				VARCHAR(200), 			-- �����
//			@I_BARNO				VARCHAR(30),			-- ���ڵ�
//			@I_ORDER				VARCHAR(30),			-- ������ȣ
//			@I_STOCK				VARCHAR(1),				-- �������
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
