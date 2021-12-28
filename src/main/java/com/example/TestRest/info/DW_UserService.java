package com.example.TestRest.info;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.TestRest.info.model.DW_Login_Res;
import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.model.ReturnMsg;
import com.example.TestRest.info.repository.DW_UserRepository;

@Service

public class DW_UserService {
	private final DW_UserRepository dw_userRepository;
	
	public DW_UserService(DW_UserRepository dw_userRepository) {
		this.dw_userRepository = dw_userRepository;
	}
	
	public List<DW_Login_Res> getDW_LoginList(String lang, String userid, String password) {
		return this.dw_userRepository.loginList(lang, userid, password);
	}
	
	//사용자 조회
	public List<DW_User> getDW_UserList(String userid, String username, String useflag) {
		return this.dw_userRepository.findList(userid, username, useflag);
	}
	
	//사용자 추가 삭제 수정 
	public List<ReturnMsg> getDW_UserSaveList(
			  String lang, 		String type, 	String userid, 		String username
			, String plantcd, 	String wccode, 	String warehouse, 	String auth, 		String role
			, String use_role, 	String useflag, String forklift, 	String etc, 		String upduser) {
				
		return this.dw_userRepository.saveList(
				  lang, 		type, 		userid, 	username
				, plantcd, 		wccode, 	warehouse, 	auth, 		role
				, use_role, 	useflag, 	forklift, 	etc, 		upduser);
	}
	
	//사용자 추가 삭제 수정 
	public List<ReturnMsg> getDW_UserSaveListJson(
			  String lang, 		String type, 	String upduser, String data) {
				
		return null;
	}

}
