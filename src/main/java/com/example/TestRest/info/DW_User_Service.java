package com.example.TestRest.info;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Login_Res;
import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.model.ReturnMsg;
import com.example.TestRest.info.repository.DW_User_Repository;


@Service
public class DW_User_Service {
	private final DW_User_Repository dw_userRepository;
	
	public DW_User_Service(DW_User_Repository dw_userRepository) {
		this.dw_userRepository = dw_userRepository;
	}
	
	public List<DW_Login_Res> getDW_LoginList(String lang, String userid, String password) {
		return this.dw_userRepository.loginList(lang, userid, password);
	}
	
	//����� ��ȸ
	public List<DW_User> getDW_UserList(String userid, String username, String useflag) {
		return this.dw_userRepository.findList(userid, username, useflag);
	}
	
	//����� �߰� ���� ���� 
	public List<ReturnMsg> getDW_UserSaveList_old(
			  String lang, 		String type, 	String userid, 		String username
			, String plantcd, 	String wccode, 	String warehouse, 	String auth, 		String role
			, String use_role, 	String useflag, String forklift, 	String etc, 		String upduser) {
				
		return this.dw_userRepository.saveList_old(
				  lang, 		type, 		userid, 	username
				, plantcd, 		wccode, 	warehouse, 	auth, 		role
				, use_role, 	useflag, 	forklift, 	etc, 		upduser);
	}
	
	//����� �߰� ���� ���� 
	public List<ReturnMsg> getDW_UserSaveList(String req_param) {
		return this.dw_userRepository.saveList(req_param);
	}

}
