package com.cos.project.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersGameBuyCountAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.back("로그인이 필요합니다", response);
			return; 
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("UsersGameBuyCountAction : gameId : "+id);
		// 1. DB연결

		UsersRepository usersRepository = UsersRepository.getInstance();

		int result = usersRepository.gameBuyCount(id);
		
		System.out.println("UsersGameBuyCountAction : result :" +result);

		PrintWriter out = response.getWriter();
		out.print(result);

	}

}
