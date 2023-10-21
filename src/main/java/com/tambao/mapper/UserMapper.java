package com.tambao.mapper;

import java.sql.ResultSet;

import com.tambao.model.RoleModel;
import com.tambao.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel users;
		try {
			users = new UserModel();
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("userName"));
			users.setFullName(resultSet.getString("fullName"));
			users.setPassword(resultSet.getString("password"));
			users.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
