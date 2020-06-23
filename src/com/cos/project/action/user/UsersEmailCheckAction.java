package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersEmailCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.findByEmail(email);
		
		Script.outText(result+"", response);
	}
}
