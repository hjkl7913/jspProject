package com.cos.project.action.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameInfos;
import com.cos.project.repository.GameInfoRepository;

public class GameHomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 1. DB연결해서 Board 목록 다불러와서
		
		GameInfoRepository gameInfoRepository = 
				GameInfoRepository.getInstance();
	
		//2. 3건만 페이징하여 가져오기(무료게임)
		List<GameInfos> freeGameInfos = gameInfoRepository.findByPriceZero();
	
		request.setAttribute("freeGameInfos", freeGameInfos);
		
		
		//베스트셀러
		List<GameInfos> BestGameInfos = gameInfoRepository.BestGameSelect();
		
		request.setAttribute("BestGameInfos", BestGameInfos);
		
		
		//출시 예정
		List<GameInfos> ExpectedGameInfos = gameInfoRepository.ExpectedGameSelect();
		
		request.setAttribute("ExpectedGameInfos", ExpectedGameInfos);
		
		// 3. 이동 home.jsp
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
	}
		

}
