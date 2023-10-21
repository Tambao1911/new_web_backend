package com.tambao.dao;

import java.util.List;

import com.tambao.model.CategoryModel;

public interface ICategoryDAO extends GennericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
    CategoryModel findOneByCode(String code);
}
