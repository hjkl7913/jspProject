package com.cos.project.action.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersHomeCodeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.href("잘못된접근입니다.", "/project/user?cmd=login", response);
			return; 
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("user/homeUseCode.jsp");
		dis.forward(request, response);
	}
	
}
