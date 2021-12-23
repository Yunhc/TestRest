package com.example.TestRest.info;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestRest.info.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class UserController {
	
	//Json 형식으로 return 한다.
	@GetMapping("/info2")
	public Object projectInfo2() {
		log.debug("/info2 start");
		
		User users = new User();
		users.id = "10001";
		users.password = "wavelink";
		users.name = "홍길동";
		users.email = "hgd@wavelink.co.kr";
		
		return users;
	}
	
	//class를 만들지 않고 직접 Json 형식으로 만든다.
	@GetMapping("/info3")
	public String customJson() {
		JsonObject jo = new JsonObject();
		
		jo.addProperty("projectName", "preword");
		jo.addProperty("author", "hello-bryan");
		jo.addProperty("createdDate", new Date().toString());
		
		JsonArray ja = new JsonArray();
		for(int i=0; i<5; i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop"+i, i);
			ja.add(jObj);
		}
		jo.add("follower", ja);
		return jo.toString();
	}
	
	@RequestMapping(value = "/api/test", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Object getApiTest() {
		//return "[{\"return\":\"OK\",\"id\":1,\"name\":\"Leanne Graham\",\"username\":\"Bret\",\"email\":\"Sincere@april.biz\"}]";
		User users = new User();
		users.id = "10001";
		users.password = "wavelink";
		users.name = "홍길동";
		users.email = "hgd@wavelink.co.kr";
		
		return users;
	}
}
