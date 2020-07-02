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
import com.google.gson.Gson;

public class AdminAnswerProcAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		UserQuestion userQuestion = usersRepository.userQuestionSearch(questionId);
		
		request.setAttribute("userQuestion", userQuestion);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminDetailAnswer.jsp");
		dis.forward(request, response);
		
	}
}
