package com.cos.project.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.model.GameCode;
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

public class AdminCodeAddProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파라메터 받기
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		String gamename = request.getParameter("gamename");
		String code = request.getParameter("code");
		
				
		
		//2. GameCode 오브젝트 변환
		GameCode gameCode = GameCode.builder()
				.gameId(gameId)
				.gamename(gamename)
				.code(code)
				.build();
				
		
		// 3. DB 연결 
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		int result = gameInfoRepository.codeAdd(gameCode);
		
		
		Script.outText(result+"", response);
		
		
		
	}
}
