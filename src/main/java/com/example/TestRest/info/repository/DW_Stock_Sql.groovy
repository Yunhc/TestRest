package com.example.TestRest.info.repository

class DW_Stock_Sql {
	public static String SELECT = """""";
	
	public static STOCK_SELECT_QUERY(String lang, String userid, 
		String werks, String lgort, String status,
		String matnr, String maktx, String mattype, 
		String customer, String date)
	{
		//	ALTER PROC [DBO].[ZZ_USP_STOCK_SEARCH]
		//		@I_LANG					VARCHAR(2),				-- ���(KR)
		//		@I_USERID           	VARCHAR(20),			-- ����ھ��̵�
		//		@I_WERKS				VARCHAR(4),				-- �÷�Ʈ
		//		@I_LGORT  				VARCHAR(4),				-- ������ġ
		//		@I_STATUS				VARCHAR(1),				-- ����
		//		@I_MATNR				VARCHAR(30),			-- �����ڵ�
		//		@I_MAKTX				VARCHAR(100),			-- �����
		//		@I_MATTYPE				VARCHAR(1),				-- ��������
		//		@I_CUSTOMER				VARCHAR(100),			-- ����
		//		@I_DATE					VARCHAR(8)				-- �����
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
