package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.model.RoleType;
import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersLoginProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유효성 검사

		if
		(
				request.getParameter("email").equals("") ||
				request.getParameter("email") == null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password") == null 
		) {
			return;
		}
		
		//1. 파라메터 받기

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		
		// 3. DB 연결 
		UsersRepository usersRepository = UsersRepository.getInstance();
		Users user = usersRepository.findByEmailAndPassword(email, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			
			if(request.getParameter("remember") != null) {
				Cookie cookie = new Cookie("remember", user.getEmail());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("remember","");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			Script.href("로그인 성공", "/project/home.jsp", response);
		} else {
			Script.back("로그인 실패", response);
		}
		
	}
}
