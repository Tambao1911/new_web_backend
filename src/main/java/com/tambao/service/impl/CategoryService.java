package com.tambao.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.tambao.dao.ICategoryDAO;
import com.tambao.model.CategoryModel;
import com.tambao.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}
	
}
