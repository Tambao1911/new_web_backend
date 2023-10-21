package com.tambao.dao.impl;

import java.util.List;

import com.tambao.dao.IUserDAO;
import com.tambao.mapper.UserMapper;
import com.tambao.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String pasword, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username=? and password=? and status = ?");

		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, pasword, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
