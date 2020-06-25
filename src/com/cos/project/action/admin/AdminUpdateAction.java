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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sun.security.provider.SHA;

public class AdminUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; 
		}
		
		String realPath = request.getServletContext().getRealPath("image");

		MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 2, "UTF-8",
				new DefaultFileRenamePolicy());
		
		
		//유효성 검사
		
		if
		(
				multi.getFilesystemName("image").equals("") ||
				multi.getFilesystemName("image") == null ||
				multi.getParameter("movie").equals("") ||
				multi.getParameter("movie") == null ||
				multi.getParameter("gamename").equals("") ||
				multi.getParameter("gamename") == null ||
				multi.getParameter("price").equals("") ||
				multi.getParameter("price") == null ||
				multi.getParameter("developer").equals("") ||
				multi.getParameter("developer") == null ||
				multi.getParameter("publisher").equals("") ||
				multi.getParameter("publisher") == null ||
				multi.getParameter("tags").equals("") ||
				multi.getParameter("tags") == null ||
				multi.getParameter("rating").equals("") ||
				multi.getParameter("rating") == null ||
				multi.getParameter("releasedate").equals("") ||
				multi.getParameter("releasedate") == null ||
				multi.getParameter("platform").equals("") ||
				multi.getParameter("platform") == null ||
				multi.getParameter("explanation").equals("") ||
				multi.getParameter("explanation") == null ||
				multi.getParameter("minos").equals("") ||
				multi.getParameter("minos") == null ||
				multi.getParameter("minprocessor").equals("") ||
				multi.getParameter("minprocessor") == null ||
				multi.getParameter("minmemory").equals("") ||
				multi.getParameter("minmemory") == null ||
				multi.getParameter("mingraphics").equals("") ||
				multi.getParameter("mingraphics") == null ||
				multi.getParameter("minstorage").equals("") ||
				multi.getParameter("minstorage") == null ||
				multi.getParameter("recomos").equals("") ||
				multi.getParameter("recomos") == null ||
				multi.getParameter("recomprocessor").equals("") ||
				multi.getParameter("recomprocessor") == null ||
				multi.getParameter("recommemory").equals("") ||
				multi.getParameter("recommemory") == null ||
				multi.getParameter("recomgraphics").equals("") ||
				multi.getParameter("recomgraphics") == null ||
				multi.getParameter("recomstorage").equals("") ||
				multi.getParameter("recomstorage") == null ||
				multi.getParameter("language").equals("") ||
				multi.getParameter("language") == null
		) {
			Script.back("빈곳 채우쇼", response);
			return;
		}
		
		
		//1. 파라메터 받기
		int id = Integer.parseInt(multi.getParameter("id"));
		String image = multi.getFilesystemName("image");
		String movie = multi.getParameter("movie");
		String gamename = multi.getParameter("gamename");
		String price = multi.getParameter("price");
		String developer = multi.getParameter("developer");
		String publisher = multi.getParameter("publisher");
		String tags = multi.getParameter("tags");
		String rating = multi.getParameter("rating");
		String releasedate = multi.getParameter("releasedate");
		String platform = multi.getParameter("platform");
		String explanation = multi.getParameter("explanation");
		String minOS = multi.getParameter("minos");
		String minProcessor = multi.getParameter("minprocessor");
		String minMemory = multi.getParameter("minmemory");
		String minGraphics = multi.getParameter("mingraphics");
		String minDirectX = multi.getParameter("mindirectX");
		String minStorage = multi.getParameter("minstorage");
		String recomOS = multi.getParameter("recomos");
		String recomProcessor = multi.getParameter("recomprocessor");
		String recomMemory = multi.getParameter("recommemory");
		String recomGraphics = multi.getParameter("recomgraphics");
		String recomDirectX = multi.getParameter("recomdirectX");
		String recomStorage = multi.getParameter("recomstorage");
		String languagesSupported = multi.getParameter("language");
		String freeDown = multi.getParameter("freedown");
				
		String fileName = null;
		String contextPath = request.getServletContext().getContextPath();
		String gameImage = null;
		
		
	
		try {

			fileName = multi.getFilesystemName("image");

			gameImage = contextPath + "/image/" + fileName;
		
		
		//2. GameInfos 오브젝트 변환
		GameInfos gameInfos = GameInfos.builder()
				.id(id)
				.image(gameImage)
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
				.freeDown(freeDown)
				.build();
		
		// 3. DB 연결 
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		int result = gameInfoRepository.update(gameInfos);
		
		if(result == 1) {
			Script.href("게임 정보  추가 성공", "/project/admin?cmd=admin", response);
		} else {
			Script.back("게임 정보 추가 실패", response);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
