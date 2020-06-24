package com.cos.project.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.model.GameInfos;
import com.cos.project.model.RoleType;
import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.SHA256;
import com.cos.project.util.Script;

import sun.security.provider.SHA;

public class AdminPageProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; 
		}
		
		//유효성 검사
		
		if
		(
				request.getParameter("image").equals("") ||
				request.getParameter("image") == null ||
				request.getParameter("movie").equals("") ||
				request.getParameter("movie") == null ||
				request.getParameter("gamename").equals("") ||
				request.getParameter("gamename") == null ||
				request.getParameter("price").equals("") ||
				request.getParameter("price") == null ||
				request.getParameter("developer").equals("") ||
				request.getParameter("developer") == null ||
				request.getParameter("publisher").equals("") ||
				request.getParameter("publisher") == null ||
				request.getParameter("tags").equals("") ||
				request.getParameter("tags") == null ||
				request.getParameter("rating").equals("") ||
				request.getParameter("rating") == null ||
				request.getParameter("releasedate").equals("") ||
				request.getParameter("releasedate") == null ||
				request.getParameter("platform").equals("") ||
				request.getParameter("platform") == null ||
				request.getParameter("explanation").equals("") ||
				request.getParameter("explanation") == null ||
				request.getParameter("minos").equals("") ||
				request.getParameter("minos") == null ||
				request.getParameter("minprocessor").equals("") ||
				request.getParameter("minprocessor") == null ||
				request.getParameter("minmemory").equals("") ||
				request.getParameter("minmemory") == null ||
				request.getParameter("mingraphics").equals("") ||
				request.getParameter("mingraphics") == null ||
				request.getParameter("mindirectX").equals("") ||
				request.getParameter("mindirectX") == null ||
				request.getParameter("minstorage").equals("") ||
				request.getParameter("minstorage") == null ||
				request.getParameter("recomos").equals("") ||
				request.getParameter("recomos") == null ||
				request.getParameter("recomprocessor").equals("") ||
				request.getParameter("recomprocessor") == null ||
				request.getParameter("recommemory").equals("") ||
				request.getParameter("recommemory") == null ||
				request.getParameter("recomgraphics").equals("") ||
				request.getParameter("recomgraphics") == null ||
				request.getParameter("recomdirectX").equals("") ||
				request.getParameter("recomdirectX") == null ||
				request.getParameter("recomstorage").equals("") ||
				request.getParameter("recomstorage") == null ||
				request.getParameter("language").equals("") ||
				request.getParameter("language") == null
		) {
			Script.back("빈곳 채우쇼", response);
			return;
		}
		
		//1. 파라메터 받기
		String image = "/project/images/"+request.getParameter("image");
		String movie = request.getParameter("movie");
		String gamename = request.getParameter("gamename");
		String price = request.getParameter("price");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		String tags = request.getParameter("tags");
		String rating = request.getParameter("rating");
		String releasedate = request.getParameter("releasedate");
		String platform = request.getParameter("platform");
		String explanation = request.getParameter("explanation");
		String minOS = request.getParameter("minos");
		String minProcessor = request.getParameter("minprocessor");
		String minMemory = request.getParameter("minmemory");
		String minGraphics = request.getParameter("mingraphics");
		String minDirectX = request.getParameter("mindirectX");
		String minStorage = request.getParameter("minstorage");
		String recomOS = request.getParameter("recomos");
		String recomProcessor = request.getParameter("recomprocessor");
		String recomMemory = request.getParameter("recommemory");
		String recomGraphics = request.getParameter("recomgraphics");
		String recomDirectX = request.getParameter("recomdirectX");
		String recomStorage = request.getParameter("recomstorage");
		String languagesSupported = request.getParameter("language");
				
		
		//2. GameInfos 오브젝트 변환
		GameInfos gameInfos = GameInfos.builder()
				.image(image)
				.movie(movie)
				.gamename(gamename)
				.price(price)
				.developer(developer)
				.publisher(publisher)
				.tags(tags)
				.rating(rating)
				.releasedate(releasedate)
				.platform(platform)
				.explanation(explanation)
				.minOS(minOS)
				.minProcessor(minProcessor)
				.minMemory(minMemory)
				.minGraphics(minGraphics)
				.minDirectX(minDirectX)
				.minStorage(minStorage)
				.recomOS(recomOS)
				.recomProcessor(recomProcessor)
				.recomMemory(recomMemory)
				.recomGraphics(recomGraphics)
				.recomDirectX(recomDirectX)
				.recomStorage(recomStorage)
				.languagesSupported(languagesSupported)
				.build();
		
		// 3. DB 연결 
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		int result = gameInfoRepository.save(gameInfos);
		
		if(result == 1) {
			Script.href("게임 정보  추가 성공", "/project/admin?cmd=admin", response);
		} else {
			Script.back("게임 정보 추가 실패", response);
		}
		
		
	}
}
