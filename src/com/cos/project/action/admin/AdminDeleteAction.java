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

public class AdminDeleteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return; 
		}
		
		if
		(
			request.getParameter("id") == null ||
			request.getParameter("id").equals("")
		)
		{
				Script.back("id가 없습니다.", response);
				return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
	
		int result = gameInfoRepository.deleteById(id);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}
	
}
