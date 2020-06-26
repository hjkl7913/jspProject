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
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameInfos> KeywordGameInfos = gameInfoRepository.findByKeyword(keyword);
		
		System.out.println("KeywordGameInfos : "+KeywordGameInfos);
		//request.setAttribute("products", products);
		
		Gson gson = new Gson();
		
		// 3. 이동 home.jsp
		
		String keySearchJsons = gson.toJson(KeywordGameInfos);
		System.out.println("keySearchJsons : "+keySearchJsons);
		Script.outJson(keySearchJsons, response);
		
		//Script.outText(products+"", response);
		
	}
}