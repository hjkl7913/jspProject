package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.Users;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;

public class UsersAcountUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 유효성 검사

		// 1. 파라메터 받기
		int id = Integer.parseInt(request.getParameter("id"));
		String displayName = request.getParameter("displayName");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		int companyVAT = Integer.parseInt(request.getParameter("companyVAT"));
		String companyAddress = request.getParameter("companyAddress");

		// 2. User 오브젝트 변환
		Users user = Users.builder()
				.id(id)
				.displayName(displayName)
				.tel(tel)
				.address(address)
				.company(company)
				.companyVAT(companyVAT)
				.companyAddress(companyAddress)
				.build();

		// 3. DB 연결
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.update(user);

		if (result == 1) {
			Script.href("회원정보 수정 성공하였습니다.", "/project/user?cmd=account&id="+id, response);
		} else {
			Script.back("회원정보 수정 실패하였습니다.", response);
		}

	}
}
