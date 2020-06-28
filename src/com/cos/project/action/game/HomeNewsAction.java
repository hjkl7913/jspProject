package com.cos.project.action.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.Dto.GameNewsTimeAgoResponseDto;
import com.cos.project.action.Action;
import com.cos.project.model.GameNews;
import com.cos.project.repository.GameNewsRepository;

public class HomeNewsAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GameNewsRepository gameNewsRepository = GameNewsRepository.getInstance();
		List<GameNews> gameNewss = gameNewsRepository.findNewsAll();
		
		for (GameNews gameNews2 : gameNewss) {
					
			java.sql.Timestamp ts = gameNews2.getCreateDate();
			//System.out.println("ts : "+ ts);
			
			long millis2 = ts.getTime();
			//System.out.println("millis2 : "+ millis2);

			long time2 = System.currentTimeMillis();

			String result = "";

			// 분
			long dateCalTime = (long) ((time2 - millis2) / 1000.0 / 60);
			
			// 시
			long dateCalTimeHour = (long) ((time2 - millis2) / 1000.0 / 60 / 60);
			
			// 일
			long dateCalTimeDay = (long) ((time2 - millis2) / 1000.0 / 60 / 60 / 24);
			
			// 년
			long dateCalTimeYear = (long) ((time2 - millis2) / 1000.0 / 60 / 60 / 24 / 365);

			if (dateCalTime < 1) {
				result = "방금 전";

			} else if (dateCalTime < 60) {
				result = dateCalTime + "분 전";

			} else if (dateCalTimeHour < 24) {
				result = dateCalTimeHour + "시간 전";

			} else if (dateCalTimeDay < 365) {
				result = dateCalTimeDay + "일 전";

			} else if (dateCalTimeYear >= 1) {
				result = dateCalTimeYear + "년 전";

			}

			//System.out.println("result : " + result );
			
			gameNews2.setTimeAgo(result);
			
		}
		
		System.out.println("gameNewss : "+gameNewss);
		
		
		request.setAttribute("gameNewss", gameNewss);

		RequestDispatcher dis = request.getRequestDispatcher("game/news.jsp");
		dis.forward(request, response);
	}
}
