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

public class GameSearchAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameInfos> AllGameInfos = gameInfoRepository.findAll();
		
		for (GameInfos keywordGameInfosPre : AllGameInfos) {
			if (keywordGameInfosPre.getGamename().length() >22) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 22)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}
			if (keywordGameInfosPre.getDeveloper().length() >22) {
				String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 22)+"...";
				keywordGameInfosPre.setDeveloper(previewDeveloper);
			}
		}
		
		
		request.setAttribute("AllGameInfos", AllGameInfos);
		
		RequestDispatcher dis = request.getRequestDispatcher("game/gamesearchpage.jsp");
		dis.forward(request, response);
	}
}
