package com.tambao.dao;

import com.tambao.model.UserModel;

public interface IUserDAO extends GennericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String pasword, Integer status);
}
