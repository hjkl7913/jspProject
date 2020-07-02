package com.cos.project.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.model.UserQuestion;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class AdminAnswerAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.href("잘못된접근입니다.", "/project/user?cmd=login", response);
			return; 
		}
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		List<UserQuestion> userQuestions = usersRepository.userQuestionAllSearch();
		
		request.setAttribute("userQuestions", userQuestions);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminAnswer.jsp");
		dis.forward(request, response);
	}
}
