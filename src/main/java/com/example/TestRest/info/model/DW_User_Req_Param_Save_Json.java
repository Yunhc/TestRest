package com.example.TestRest.info.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DW_User_Req_Param_Save_Json {
	public String lang; 		
	public String type; 		
	public String upduser;
	public List<DW_User> data;
}
