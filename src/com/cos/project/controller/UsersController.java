package com.cos.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.action.user.UsersEmailCheckAction;
import com.cos.project.action.user.UsersJoinAction;
import com.cos.project.action.user.UsersJoinProcAction;
import com.cos.project.action.user.UsersLoginAction;
import com.cos.project.action.user.UsersLoginProcAction;
import com.cos.project.action.user.UsersLogoutAction;


@WebServlet("/user")
public class UsersController extends HttpServlet {
	private static final String TAG = "UsersController : ";
	private static final long serialVersionUID = 1L;
       
    
    public UsersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}


	public Action router(String cmd) {
		if(cmd.equals("join")) {
			return new UsersJoinAction();
		}else if(cmd.equals("joinProc")) {
			return new UsersJoinProcAction();
		}else if (cmd.equals("userEmailCheck")) { 
			return new UsersEmailCheckAction();
		}else if(cmd.equals("login")) {
			return new UsersLoginAction();
		}else if(cmd.equals("loginProc")) {
			return new UsersLoginProcAction();
		}else if(cmd.equals("logout")) {
			return new UsersLogoutAction();
		}
		return null;
	}

}
