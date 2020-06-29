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
	
		
		
		for (GameInfos keywordGameInfosPre : freeGameInfos) {
			if (keywordGameInfosPre.getGamename().length() >20) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 20)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}			
		}
		
		request.setAttribute("freeGameInfos", freeGameInfos);
		
		
		//베스트셀러
		List<GameInfos> BestGameInfos = gameInfoRepository.BestGameSelect();
		
		
		
		for (GameInfos keywordGameInfosPre : BestGameInfos) {
			if (keywordGameInfosPre.getGamename().length() >14) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 14)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}
			if (keywordGameInfosPre.getDeveloper().length() >14) {
				String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 14)+"...";
				keywordGameInfosPre.setDeveloper(previewDeveloper);
			}
		}
		
		request.setAttribute("BestGameInfos", BestGameInfos);
		
		
		//출시 예정
		List<GameInfos> ExpectedGameInfos = gameInfoRepository.ExpectedGameSelect();
		
		
		
		for (GameInfos keywordGameInfosPre : ExpectedGameInfos) {
			if (keywordGameInfosPre.getGamename().length() >27) {
				String previewGamename = keywordGameInfosPre.getGamename().substring(0, 27)+"...";
				keywordGameInfosPre.setGamename(previewGamename);
			}
			if (keywordGameInfosPre.getDeveloper().length() >27) {
				String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 27)+"...";
				keywordGameInfosPre.setDeveloper(previewDeveloper);
			}
		}
		
		request.setAttribute("ExpectedGameInfos", ExpectedGameInfos);
		
		//최고 인기작
		List<GameInfos> greatBestGameInfos = gameInfoRepository.greateBestGameSelect();
				
				
				
				for (GameInfos keywordGameInfosPre : greatBestGameInfos) {
					if (keywordGameInfosPre.getGamename().length() >26) {
						String previewGamename = keywordGameInfosPre.getGamename().substring(0, 26)+"...";
						keywordGameInfosPre.setGamename(previewGamename);
					}
					if (keywordGameInfosPre.getDeveloper().length() >26) {
						String previewDeveloper = keywordGameInfosPre.getDeveloper().substring(0, 26)+"...";
						keywordGameInfosPre.setDeveloper(previewDeveloper);
					}
				}
		System.out.println("greatBestGameInfos : "+greatBestGameInfos);
		request.setAttribute("greatBestGameInfos", greatBestGameInfos);
		
		// 3. 이동 home.jsp
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
	}
		

}
