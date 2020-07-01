package com.cos.project.action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;

public class AdminCodeAddAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String gamename = request.getParameter("gamename");
		
		request.setAttribute("id", id);
		request.setAttribute("gamename", gamename);
	
		RequestDispatcher dis = request.getRequestDispatcher("admin/adminCodeAddPage.jsp");
		dis.forward(request, response);
	}
}
