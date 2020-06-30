package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersGameBuyCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String gamename = request.getParameter("gamename");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.userGamebuyCheck(gameId,userId,gamename);
		
		Script.outText(result+"", response);
	}
}
