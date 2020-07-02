package com.cos.project.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.model.AdminAnswer;
import com.cos.project.model.UserQuestion;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.EmailAnswer;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class AdminAnswerAfterAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String displayName = request.getParameter("displayName");
		String email = request.getParameter("email");
		String platform = request.getParameter("platform");
		String language = request.getParameter("language");
		String question = request.getParameter("question");
		String writeDate = request.getParameter("writeDate");
		String answer = request.getParameter("answer");
		
		
		int result3 = EmailAnswer.AdminEmailAnswer( displayName, email, question, writeDate, answer);
		
		
		AdminAnswer adminAnswer = AdminAnswer.builder()
				.userId(userId)
				.displayName(displayName)
				.email(email)
				.platform(platform)
				.language(language)
				.question(question)
				.answer(answer)
				.writeDate(writeDate)
				.build();
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		
		
		int result = usersRepository.answerComplete(adminAnswer);
		
		
		if(result != 1){
			return;
		}
		
		int result2 = usersRepository.userQuestionDelete(questionId);
		
		Script.href("답변완료", "/project/admin?cmd=answer", response);
		
	}
}
