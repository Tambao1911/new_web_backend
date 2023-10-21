package com.tambao.dao;

import java.util.List;

import com.tambao.model.NewsModel;
import com.tambao.paging.Pageble;

public interface INewDAO extends GennericDAO<NewsModel>{
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	NewsModel findOne(Long id);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
}
