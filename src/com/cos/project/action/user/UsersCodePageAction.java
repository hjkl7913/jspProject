package com.cos.project.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.UsedGameCode;
import com.cos.project.repository.UsersRepository;

public class UsersCodePageAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("id"));
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		List<UsedGameCode> usedGameCodes = usersRepository.UsedGameCodeSearch(userId);
		
		request.setAttribute("usedGameCodes", usedGameCodes);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("user/accountCode.jsp");
		dis.forward(request, response);
	}
}
