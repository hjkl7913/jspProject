package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.UserQuestion;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersQuestionProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String displayName = request.getParameter("displayName");
		String email = request.getParameter("email");
		String platform = request.getParameter("platform");
		String language = request.getParameter("language");
		String question = request.getParameter("question");
		
		UserQuestion userQuestion = UserQuestion.builder()
				.userId(userId)
				.displayName(displayName)
				.email(email)
				.platform(platform)
				.language(language)
				.question(question)
				.build();
		
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		int result = usersRepository.questionAdd(userQuestion);
		
		Script.outText(result+"", response);
	}
}
