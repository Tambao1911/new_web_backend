package com.tambao.service;

import com.tambao.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String pasword, Integer status);
}
