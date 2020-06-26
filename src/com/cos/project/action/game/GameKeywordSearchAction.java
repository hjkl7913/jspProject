package com.cos.project.action.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameInfos;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class GameKeywordSearchAction implements Action{
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
		
		String keyword = request.getParameter("keyword");
		System.out.println("keyword : "+keyword);
		
		//String keyword = request.getParameter("keyword");
		//System.out.println("keyword : "+keyword);
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameInfos> keywordGameInfos = gameInfoRepository.findByKeyword(keyword);
		
		//System.out.println("KeywordGameInfos : "+KeywordGameInfos);
		//request.setAttribute("products", products);
		
		for (GameInfos keywordGameInfosPre : keywordGameInfos) {
			if (keywordGameInfosPre.getGamename().length() >22) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 22)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}
			if (keywordGameInfosPre.getDeveloper().length() >22) {
				String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 22)+"...";
				keywordGameInfosPre.setDeveloper(previewDeveloper);
			}
		}
		
		
		Gson gson = new Gson();
		
		// 3. 이동 home.jsp
		
		String keySearchJsons = gson.toJson(keywordGameInfos);
		System.out.println("keySearchJsons : "+keySearchJsons);
		Script.outJson(keySearchJsons, response);
		
		//Script.outText(products+"", response);
		
	}
}