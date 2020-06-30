package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class UsersCodeCheckAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId= Integer.parseInt(request.getParameter("userId"));
		String tempCode = request.getParameter("code");
		String code = tempCode.replaceAll("-", "");
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.gameCodeCheck(code);
		
		Script.outText(result+"", response);
	}
}
