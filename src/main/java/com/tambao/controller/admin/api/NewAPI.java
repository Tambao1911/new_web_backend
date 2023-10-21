package com.tambao.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tambao.model.NewsModel;
import com.tambao.model.UserModel;
import com.tambao.service.INewService;
import com.tambao.utils.HttpUtil;
import com.tambao.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newModel.setCreatedBy(((UserModel)SessionUtil.getInstance().getValue(request,"USERMODEL")).getUserName());
		newModel = newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel updateNew = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		updateNew.setModifiedBy(((UserModel)SessionUtil.getInstance().getValue(request,"USERMODEL")).getUserName());
		updateNew = newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
