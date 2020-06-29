package com.cos.project.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.util.Script;

public class GameBuyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.back("로그인이 필요합니다", response);
			return; 
		}
		
		int id = Integer.parseInt(request.getParameter("id"));

		// 1. DB연결

		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();

		int result = gameInfoRepository.buyGame(id);

		PrintWriter out = response.getWriter();
		out.print(result);

	}

}
