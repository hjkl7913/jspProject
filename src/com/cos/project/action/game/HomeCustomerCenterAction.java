package com.cos.project.action.game;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.Dto.GameNewsTimeAgoResponseDto;
import com.cos.project.action.Action;
import com.cos.project.model.GameNews;
import com.cos.project.repository.GameNewsRepository;

public class HomeCustomerCenterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dis = request.getRequestDispatcher("game/spCenter.jsp");
		dis.forward(request, response);
		
		
	}
}
