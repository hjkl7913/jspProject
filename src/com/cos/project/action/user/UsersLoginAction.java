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

import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;

public class UsersLoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
		dis.forward(request, response);
	}
	
}
