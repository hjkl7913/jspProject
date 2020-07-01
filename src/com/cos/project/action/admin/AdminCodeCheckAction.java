package com.cos.project.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class AdminCodeCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tempCode = request.getParameter("code");
		String code = tempCode.replaceAll("-", "");
		
		int codeLength = code.length();
		System.out.println("AdminCodeCheckAction : codeLength : "+codeLength);
		
		if(codeLength != 20) {
			Script.outText("long", response);
			return;
		}
		
		//코드 체크 
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();

		int result = gameInfoRepository.gameCodeCheck(code);

		Script.outText(result+"", response);

	}

}
