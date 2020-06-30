package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.SHA256;
import com.cos.project.util.Script;

public class UsersPasswordUpdateAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String rawPassword = request.getParameter("newPassword");
		String password = SHA256.encodeSha256(rawPassword);
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.passwordUpdate(id,password);
		
		Script.outText(result+"", response);
	}
}
