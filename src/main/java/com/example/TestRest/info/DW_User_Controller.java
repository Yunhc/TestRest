package com.example.TestRest.info;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.TestRest.Util;
import com.example.TestRest.info.model.DW_Login_Req_Param;
import com.example.TestRest.info.model.DW_Login_Res;
import com.example.TestRest.info.model.DW_User;
import com.example.TestRest.info.model.DW_User_Req_Param;
import com.example.TestRest.info.model.DW_User_Req_Param_Save;
import com.example.TestRest.info.model.ReturnMsg;


//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;

import org.json.JSONArray;
import org.json.JSONObject;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController

public class DW_User_Controller {
	private DW_User_Service dw_userService;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public DW_User_Controller(DW_User_Service dw_userService) {
		this.dw_userService = dw_userService;
	}

	
	@CrossOrigin("*")
	@RequestMapping(value = "/dw_userList", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_userList(@RequestParam(value="userid") String userid, 
							  @RequestParam(value="username") String username, 
							  @RequestParam(value="useflag") String useflag) {
		log.debug("/dw_userList start");
		List<DW_User> dw_userList = dw_userService.getDW_UserList(userid, username, useflag);
		return dw_userList;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/api/auth/signin")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_loginList_post(@RequestBody DW_Login_Req_Param req_param) {
		log.debug("/api/auth/signin start");
		log.debug("/api/auth/signin request = {}", req_param.toString());
		List<DW_Login_Res> dw_login_res = dw_userService.getDW_LoginList(req_param.lang, req_param.userid, req_param.password);
		return dw_login_res;
	}
	

	
	@CrossOrigin("*")
//	@RequestMapping(value = "/dw_userList_p", method = RequestMethod.POST)
	@PostMapping(value="/dw_userList_p")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_userList_post(@RequestBody DW_User_Req_Param req_param) {
		log.debug("/dw_userList_post start");
		log.debug("/dw_userList_post request = {}", req_param.toString());
		List<DW_User> dw_userList = dw_userService.getDW_UserList(req_param.userid, req_param.username, req_param.useflag);
		return dw_userList;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/dw_usersaveList_p")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_usersaveList_post(@RequestBody DW_User_Req_Param_Save req_param) {
		log.debug("/dw_usersaveList_post start");
		log.debug("/dw_usersaveList_post request = {}", req_param.toString());
		List<ReturnMsg> dw_usersaveList = dw_userService.getDW_UserSaveList_old(
				  req_param.lang, 		req_param.type, 	req_param.userid, 		req_param.username
				, req_param.plantcd, 	req_param.wccode, 	req_param.warehouse, 	req_param.auth, 		req_param.role
				, req_param.use_role, 	req_param.useflag, 	req_param.forklift, 	req_param.etc, 			req_param.upduser);
		return dw_usersaveList;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/dw_usersaveList_p_j_old", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
//	public Object dw_usersaveList_post_j(@RequestBody DW_User_Req_Param_Save_Json req_param) {
//		log.debug("[/dw_usersaveList_post_j start]");
//		log.debug("[/dw_usersaveList_post_j request] = {}", req_param.toString());
//		log.debug("[/dw_usersaveList_post_j request] = {}", req_param.upduser);
//		log.debug("[/dw_usersaveList_post_j request] = {}", Object.keys(req_param.data).length);
	
	public Object dw_usersaveList_post_j_old(@RequestBody String req_param) {
		
		JSONObject jsonObject = new JSONObject(req_param);
	
		
		log.debug("[upduser] = {}", jsonObject.get("upduser"));
		log.debug("[upduser] = {}", jsonObject.get("data"));
		
		JSONArray jsonData = jsonObject.getJSONArray("data");
		List<ReturnMsg> returnMsgList = null;
		
		log.debug("[Data Count] = {}", jsonData.length());
		
		for(int i=0; i<jsonData.length(); i++) {
			JSONObject dtlObject = jsonData.getJSONObject(i);
			log.debug("[userid] = {}", dtlObject.get("userid"));
			
			returnMsgList = dw_userService.getDW_UserSaveList_old(
					  Util.GetData(jsonObject.getString("lang")), 		Util.GetData(jsonObject.getString("type")), 	Util.GetData(dtlObject.getString("userid")) 		
					, Util.GetData(dtlObject.getString("username")), 	Util.GetData(dtlObject.getString("plantcd")), 	Util.GetData(dtlObject.getString("wccode"))
					, Util.GetData(dtlObject.getString("warehouse")), 	Util.GetData(dtlObject.getString("auth")), 		Util.GetData(dtlObject.getString("role"))
					, Util.GetData(dtlObject.getString("use_role")), 	Util.GetData(dtlObject.getString("useflag")), 	Util.GetData(dtlObject.getString("forklift"))
					, Util.GetData(dtlObject.getString("etc")), 		Util.GetData(jsonObject.getString("upduser"))
			);
			
			log.debug("[process status] = {}", returnMsgList.get(0).status);
			if (!returnMsgList.get(0).status.equals("OK")) {
				log.debug("[process status] = {}", "NG");
				log.debug("[process msg] = {}", returnMsgList.get(0).msg);
				break;
			}
			else{
				log.debug("[process status] = {}", "OK");
				log.debug("[process msg] = {}", returnMsgList.get(0).msg);
			}
		}
		
		return returnMsgList;
	}
	
	@CrossOrigin("*")
	@PostMapping(value="/dw_usersaveList_p_j", produces = "application/json; charset=utf8")
	@ResponseStatus(value = HttpStatus.OK)
	public Object dw_usersaveList_post_j(@RequestBody String req_param) {		
		log.debug("/dw_usersaveList_p_j");
//		log.debug("/dw_usersaveList_p_j = {}", req_param.toString());
		List<ReturnMsg> returnMsgList = dw_userService.getDW_UserSaveList(req_param);
		return returnMsgList;
	}
}


