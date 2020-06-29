package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;

public class UsersAcountAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		Users accountUser = usersRepository.findById(id);
		
		request.setAttribute("accountUser", accountUser);
		
		RequestDispatcher dis = request.getRequestDispatcher("user/account.jsp");
		dis.forward(request, response);
	}
}
