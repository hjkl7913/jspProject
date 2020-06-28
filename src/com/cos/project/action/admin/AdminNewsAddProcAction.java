package com.cos.project.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.model.GameInfos;
import com.cos.project.model.GameNews;
import com.cos.project.model.RoleType;
import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.GameNewsRepository;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.SHA256;
import com.cos.project.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sun.security.provider.SHA;

public class AdminNewsAddProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String realPath = request.getServletContext().getRealPath("image");

		MultipartRequest multi = new MultipartRequest(request, realPath, 1024 * 1024 * 2, "UTF-8",
				new DefaultFileRenamePolicy());
		
		
		//유효성 검사
		
		if
		(
				multi.getFilesystemName("image").equals("") ||
				multi.getFilesystemName("image") == null ||
				multi.getParameter("news").equals("") ||
				multi.getParameter("news") == null 
				
		) {
			Script.back("빈칸이 있습니다.", response);
			return;
		}
		

		
		//1. 파라메터 받기
		int gameId = Integer.parseInt(multi.getParameter("gameId"));
		String image = multi.getFilesystemName("image");
		String content = multi.getParameter("news");
		
				
		String fileName = null;
		String contextPath = request.getServletContext().getContextPath();
		String gameImage = null;
		
		
		try {

			fileName = multi.getFilesystemName("image");

			gameImage = contextPath + "/image/" + fileName;
		
		
		//2. GameInfos 오브젝트 변환
		GameNews gameNews = GameNews.builder()
				.gameId(gameId)
				.Image(gameImage)
				.content(content)
				.build();
				
		
		// 3. DB 연결 
		GameNewsRepository gaNewsRepository = GameNewsRepository.getInstance();
		int result = gaNewsRepository.newsAdd(gameNews);
		
		if(result == 1) {
			Script.href("새소식 추가 성공", "/project/admin?cmd=admin", response);
		} else {
			Script.back("새소식 추가  실패", response);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("AdminNewsAddProcAction 오류  : "+e.getMessage());
		}
		
		
	}
}
