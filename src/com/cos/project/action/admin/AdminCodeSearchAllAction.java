package com.cos.project.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.model.UsedGameCode;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.UsersRepository;

public class AdminCodeSearchAllAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameCode> gameCodes = gameInfoRepository.AdminCodeSearchAll();
		
		request.setAttribute("gameCodes", gameCodes);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminCodeAllPage.jsp");
		dis.forward(request, response);
	}
}
