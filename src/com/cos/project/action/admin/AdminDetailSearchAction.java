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
import com.cos.project.util.Script;


public class AdminDetailSearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("AdminDetailSearchAction : id : "+id);
		// 1. DB연결해서 Board 목록 다불러와서
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		//2. 가져오기
		
		GameInfos gameInfos = gameInfoRepository.findById(id);
		
		request.setAttribute("gameInfos", gameInfos);
		
		// 3. 이동 home.jsp
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminSearchPage.jsp");
		dis.forward(request, response);
		
	}
	
}
