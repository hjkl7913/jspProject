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

public class GameTagSearchAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tags = request.getParameter("tags");
		System.out.println("tags : "+tags);
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameInfos> gameInfos = gameInfoRepository.findByTags(tags);
		
		System.out.println("gameInfos : "+gameInfos.size());
		//request.setAttribute("products", products);
		
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
		
		Gson gson = new Gson();
		
		// 3. 이동 home.jsp
		
		String tagSearchJsons = gson.toJson(gameInfos);
		System.out.println("tagSearchJsons : "+tagSearchJsons);
		Script.outJson(tagSearchJsons, response);
		
		//Script.outText(products+"", response);
		
	}
}