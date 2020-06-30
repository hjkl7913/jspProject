package com.cos.project.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.model.Carts;
import com.cos.project.repository.UsersRepository;

public class UsersAcountCartAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); //userid
		
		UsersRepository usersRepository = UsersRepository.getInstance();
		
		List<Carts> carts  = usersRepository.findCartByUserId(id);
		
		System.out.println("carts : "+carts);
		
		request.setAttribute("carts", carts);
		
		RequestDispatcher dis = request.getRequestDispatcher("user/cartList.jsp");
		dis.forward(request, response);
	}
}
