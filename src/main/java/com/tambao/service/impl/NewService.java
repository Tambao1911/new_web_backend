package com.tambao.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.tambao.dao.ICategoryDAO;
import com.tambao.dao.INewDAO;
import com.tambao.model.CategoryModel;
import com.tambao.model.NewsModel;
import com.tambao.paging.Pageble;
import com.tambao.service.INewService;

public class NewService implements INewService {
	@Inject
	private INewDAO newDao;

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
        newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
        updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewsModel findOne(long id) {
		NewsModel newsModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
