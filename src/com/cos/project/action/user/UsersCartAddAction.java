package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersCartAddAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String gamename = request.getParameter("gamename");
		String contentImage = request.getParameter("contentImage");
		String price = request.getParameter("price");
		
		System.out.println("gameId : "+gameId);
		System.out.println("userId : "+userId);
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		int result = usersRepository.cartAdd(gameId, userId, gamename, contentImage, price);
		
		Script.outText(result+"", response);
	}
}
