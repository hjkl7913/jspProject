package com.cos.project.action.admin;

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
import com.cos.project.util.Script;

public class AdminCodeDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int codeId = Integer.parseInt(request.getParameter("codeId"));
		
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
	
		int result = gameInfoRepository.adminCodeDeleteById(codeId);
		
		Script.outText(result+"", response);
		
	}
	
}
