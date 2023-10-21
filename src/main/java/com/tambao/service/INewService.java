package com.tambao.service;

import java.util.List;

import com.tambao.model.NewsModel;
import com.tambao.paging.Pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newModel);
	NewsModel update(NewsModel updateNew);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
	NewsModel findOne(long id);
}
