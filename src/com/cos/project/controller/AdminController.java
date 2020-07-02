package com.cos.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.action.admin.AdminAnswerAction;
import com.cos.project.action.admin.AdminAnswerAfterAction;
import com.cos.project.action.admin.AdminAnswerProcAction;
import com.cos.project.action.admin.AdminCodeAddAction;
import com.cos.project.action.admin.AdminCodeAddProcAction;
import com.cos.project.action.admin.AdminCodeCheckAction;
import com.cos.project.action.admin.AdminCodeDeleteAction;
import com.cos.project.action.admin.AdminCodeReSearchAllAction;
import com.cos.project.action.admin.AdminCodeSearchAllAction;
import com.cos.project.action.admin.AdminDeleteAction;
import com.cos.project.action.admin.AdminDetailSearchAction;
import com.cos.project.action.admin.AdminNewsAddAction;
import com.cos.project.action.admin.AdminNewsAddProcAction;
import com.cos.project.action.admin.AdminPageAction;
import com.cos.project.action.admin.AdminPageAddAction;
import com.cos.project.action.admin.AdminSearchAction;
import com.cos.project.action.admin.AdminSearchAllAction;
import com.cos.project.action.admin.AdminUpdateAction;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final String TAG = "AdminController : ";
	private static final long serialVersionUID = 1L;
       
    
    public AdminController() {
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
		if(cmd.equals("admin")) {
			return new AdminPageAction();
		}else if(cmd.equals("adminProc")) {
			return new AdminPageAddAction();
		}else if(cmd.equals("search")) {
			return new AdminSearchAction();
		}else if(cmd.equals("detailsearch")) {
			return new AdminDetailSearchAction();
		}else if(cmd.equals("update")) {
			return new AdminUpdateAction();
		}else if(cmd.equals("delete")) {
			return new AdminDeleteAction();
		}else if(cmd.equals("newsAdd")) {
			return new AdminNewsAddAction();
		}else if(cmd.equals("newsAddProc")) {
			return new AdminNewsAddProcAction();
		}else if(cmd.equals("searchAll")) {
			return new AdminSearchAllAction();
		}else if(cmd.equals("codeAdd")) {
			return new AdminCodeAddAction();
		}else if(cmd.equals("codeAddProc")) {
			return new AdminCodeAddProcAction();
		}else if(cmd.equals("adminCodeCheck")) {
			return new AdminCodeCheckAction();
		}else if(cmd.equals("adminCodeSearchAll")) {
			return new AdminCodeSearchAllAction();
		}else if(cmd.equals("adminCodeReSearchAll")) {
			return new AdminCodeReSearchAllAction();
		}else if(cmd.equals("adminCodeDelete")) {
			return new AdminCodeDeleteAction();
		}else if(cmd.equals("answer")) {
			return new AdminAnswerAction();
		}else if(cmd.equals("answerProc")) {
			return new AdminAnswerProcAction();
		}else if(cmd.equals("answerComplete")) {
			return new AdminAnswerAfterAction();
		}
		
		
		return null;
	}

}
