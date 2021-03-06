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
import com.google.gson.Gson;

public class UsersCodeCheckAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.href("잘못된접근입니다.", "/project/user?cmd=login", response);
			return; 
		}
		
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String tempCode = request.getParameter("code");
		String code = tempCode.replaceAll("-", "");

		UsersRepository usersRepository = UsersRepository.getInstance();

		int result = usersRepository.gameCodeCheck(code);
		
		if (result == 1) {
			GameCode gameCode = usersRepository.gameCodeUse(code);
			String gamename = gameCode.getGamename();
			System.out.println(gamename);
			Script.outText(gamename, response);
		} else{
			Script.outText(result+"", response);
		}

	}

}
