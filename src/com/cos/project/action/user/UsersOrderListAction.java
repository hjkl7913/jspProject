package com.cos.project.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.Dto.OrderListResponseDto;
import com.cos.project.action.Action;
import com.cos.project.model.Carts;
import com.cos.project.model.OrderList;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class UsersOrderListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));  //유저 아이디 

		UsersRepository usersRepository = UsersRepository.getInstance();
		
		List<OrderListResponseDto> orderListResponseDtos  = usersRepository.userOrderListAll(id);
		
		System.out.println("orderListResponseDtos :"+orderListResponseDtos);
		
		
		request.setAttribute("orderListResponseDtos", orderListResponseDtos);
		
		RequestDispatcher dis = request.getRequestDispatcher("user/accountBuyList.jsp");
		dis.forward(request, response);
		
	}
}
