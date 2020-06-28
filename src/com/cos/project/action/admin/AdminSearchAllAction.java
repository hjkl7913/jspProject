package com.cos.project.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameInfos;
import com.cos.project.repository.GameInfoRepository;

public class AdminSearchAllAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameInfos> AllGameInfos = gameInfoRepository.findAll();
		
		
		request.setAttribute("AllGameInfos", AllGameInfos);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminSearchPage.jsp");
		dis.forward(request, response);
	}
}
