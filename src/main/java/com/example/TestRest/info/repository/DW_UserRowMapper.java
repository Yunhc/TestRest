package com.example.TestRest.info.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.TestRest.info.model.DW_User;

public class DW_UserRowMapper implements RowMapper<DW_User>{
	@Override
	public DW_User mapRow(ResultSet rs, int rowNum) throws SQLException {
		DW_User user = new DW_User();
		
		user.setSel(rs.getString("sel"));
		user.setUserid(rs.getString("userid"));
		user.setUsername(rs.getString("username"));
		user.setUserpwd(rs.getString("userpwd"));
		user.setPlantcd(rs.getString("plantcd"));
		user.setWccode(rs.getString("wccode"));
		user.setWarehouse(rs.getString("warehouse"));
		user.setAuth(rs.getString("auth"));
		user.setRole(rs.getString("role"));
		user.setUse_role(rs.getString("use_role"));
		user.setUseflag(rs.getString("useflag"));
		user.setForklift(rs.getString("forklift"));
		user.setEtc(rs.getString("etc"));
		user.setUpduser(rs.getString("upduser"));
		user.setUpddate(rs.getString("upddate"));
		return user;
	}
}
