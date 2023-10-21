package com.tambao.model;

public class CommentModel extends AbstractModel<CommentModel> {
	private String content;
	private Long userId;
	private Long newId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long userId) {
		this.userId = userId;
	}

	public Long getNew_id() {
		return newId;
	}

	public void setNew_id(Long newId) {
		this.newId = newId;
	}

}
