package com.cos.project.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.Dto.HomeUseCodeResponseDto;
import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.model.UsedGameCode;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class UsersHomeUseCodeCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tempCode = request.getParameter("code");
		String code = tempCode.replaceAll("-", "");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		GameCode gameCode = usersRepository.gameCodeUse(code);
		
		Gson gson = new Gson();
		if (gameCode != null) {
			HomeUseCodeResponseDto homeUseCodeResponseDto = usersRepository.homeCodeCheck(code);
			String homeUseCodeDto = gson.toJson(homeUseCodeResponseDto);
			Script.outJson(homeUseCodeDto, response);
		} else {
			Script.outJson(null, response);
		}		 

	}
}
