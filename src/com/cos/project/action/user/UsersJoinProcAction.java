package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.model.RoleType;
import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersJoinProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유효성 검사
		
		String dd = request.getParameter("username");

		if
		(
				request.getParameter("username").equals("") ||
				request.getParameter("username") == null ||
				request.getParameter("displayname").equals("") ||
				request.getParameter("displayname") == null ||
				request.getParameter("email").equals("") ||
				request.getParameter("email") == null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password") == null 
		) {
			return;
		}
		
		//1. 파라메터 받기
		String username = request.getParameter("username");
		String displayName = request.getParameter("displayname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userRole = RoleType.USER.toString();
		
		//2. User 오브젝트 변환
		Users user = Users.builder()
				.username(username)
				.displayName(displayName)
				.email(email)
				.password(password)
				.userRole(userRole)
				.build();
		
		// 3. DB 연결 
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.save(user);
		
		if(result == 1) {
			Script.href("회원가입에 성공하였습니다.", "/project/user?cmd=login", response);
		} else {
			Script.back("회원가입에 실패하였습니다.", response);
		}
		
		
	}
}
