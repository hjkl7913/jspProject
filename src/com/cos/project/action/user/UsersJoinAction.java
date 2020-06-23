package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;

public class UsersJoinAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UsersJoinAction : 여기왔니??????");
		RequestDispatcher dis = request.getRequestDispatcher("user/join.jsp");
		dis.forward(request, response);
	}
}
