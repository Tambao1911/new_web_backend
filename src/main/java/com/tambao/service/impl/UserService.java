package com.tambao.service.impl;

import javax.inject.Inject;

import com.tambao.dao.IUserDAO;
import com.tambao.model.UserModel;
import com.tambao.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDao;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String pasword, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, pasword, status);
	}

}
