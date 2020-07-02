package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersCodeUseCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.href("잘못된접근입니다.", "/project/user?cmd=login", response);
			return; 
		}
		
		
		int userId= Integer.parseInt(request.getParameter("userId"));
		String tempCode = request.getParameter("code");
		String code = tempCode.replaceAll("-", "");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		//gamecode 정보 가져오기
		GameCode gameCode = usersRepository.gameCodeUse(code);
		int codeId = gameCode.getCodeId();
		int gameId = gameCode.getGameId();
		String gamename = gameCode.getGamename();
		String Gcode = gameCode.getCode();
		 
		// 구매한 게임인지 확인
		int result = usersRepository.userGamebuyCheck(gameId,userId,gamename);
		
		Script.outText(result+"", response);
	}
}
