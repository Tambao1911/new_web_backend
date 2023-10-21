package com.tambao.mapper;

import java.sql.ResultSet;

import com.tambao.model.NewsModel;

public class NewMapper implements RowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		NewsModel news;
		try {
			news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryId"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate")!=null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby")!=null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
