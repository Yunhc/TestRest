package com.example.TestRest.info.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DWT_Good_Issue_Scan_Res_Param {
	// ���ڵ� ��ĵȭ�鿡�� ȣ��� ���� ��
	public String matnr;
	public int posnr;
	public String orderqtybdl;
	public String procqty;	
	public String orderqtypc;
	public String umrez;
	public String maktx;
	public String ztype;
	public String uepos;
	public String matnrc;
	public String kunnr;
	public String zkunnrnm;
	public String zshipno;
	
	public String code;
	public String message;
	
	// ���ڵ� ����ȭ�鿡�� ȣ��� ���� �� matnr, maktx, code, message�� �������� ���
	public String sel;
	public String barno;
	public String qty;
	public String meins;
//	public String matnr;
//	public String maktx;
	public String sobdqty;
}
