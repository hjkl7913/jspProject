package com.cos.project.action.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.Dto.GameNewsTimeAgoResponseDto;
import com.cos.project.action.Action;
import com.cos.project.model.GameNews;
import com.cos.project.repository.GameNewsRepository;
import com.cos.project.util.Script;

public class HomeCustomerQuetionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.href("로그인이 필요합니다.", "/project/user?cmd=login", response);
			return; 
		}
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("game/customerQuestion.jsp");
		dis.forward(request, response);
		
		
	}
}
