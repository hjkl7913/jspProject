package com.cos.project.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.model.GameInfos;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersCartDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; 
		}
		
		int id = Integer.parseInt(request.getParameter("id"));  //cart 테이블 id
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		int result = usersRepository.cartDeleteById(id);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
	
}
