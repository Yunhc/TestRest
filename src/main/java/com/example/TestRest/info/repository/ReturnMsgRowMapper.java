package com.example.TestRest.info.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.TestRest.info.model.ReturnMsg;

public class ReturnMsgRowMapper implements RowMapper<ReturnMsg> {
	@Override
	public ReturnMsg mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReturnMsg rtnmsg = new ReturnMsg();
		
		rtnmsg.setStatus(rs.getString("status"));
		rtnmsg.setMsg(rs.getString("msg"));
		
		return rtnmsg;
	}
}
