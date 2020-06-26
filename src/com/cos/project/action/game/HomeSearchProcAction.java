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
import com.cos.project.util.Script;


public class HomeSearchProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if
		(
			request.getParameter("keyword") == null ||
			request.getParameter("keyword").equals("")
		)
		{
				Script.back("검색 키워드가 없습니다.", response);
				return;
		}
		
		int page = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		// 1. DB연결해서 Board 목록 다불러와서
		
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		
		//2. 3건만 페이징하여 가져오기
		
		List<GameInfos> gameInfos = gameInfoRepository.findByPageAndKeyword(page,keyword);
		
		for (GameInfos keywordGameInfosPre : gameInfos) {
			if (keywordGameInfosPre.getGamename().length() >22) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 22)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}
			if (keywordGameInfosPre.getDeveloper().length() >22) {
				String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 22)+"...";
				keywordGameInfosPre.setDeveloper(previewDeveloper);
			}
		}
		
		
		request.setAttribute("gameInfos", gameInfos);
		
		//int result = gameInfoRepository.findBoardCount(keyword);
		//System.out.println("AdminSearchAction : result: "+result);

		
		RequestDispatcher dis = request.getRequestDispatcher("game/gamesearchpage.jsp");
		dis.forward(request, response);
		
	}
	
}
