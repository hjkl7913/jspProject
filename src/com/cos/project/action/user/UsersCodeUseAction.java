package com.cos.project.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.model.UsedGameCode;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class UsersCodeUseAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		// 구매목록 테이블에 추가
		int BuyGameResult = usersRepository.BuyGameAdd(gameId,userId,gamename);
		
		// UsedGameCode 테이블에 추가
		int UsedAddResult = usersRepository.UsedGameCodeAdd(userId,gameId,gamename,Gcode);
		
		// gamecode 테이블에서 지우기
		int deleteResult = usersRepository.gameCodeDelete(codeId);
		
		// userId 로 검색해서 사용한 코드 목록 가져오기
		List<UsedGameCode> usedGameCodes = usersRepository.UsedGameCodeSearch(userId);
		
		
		Gson gson = new Gson();
		
		String usedGameCodeJsons = gson.toJson(usedGameCodes);
		
		Script.outJson(usedGameCodeJsons, response);
	}
}
