package com.cos.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.action.admin.AdminDetailSearchAction;
import com.cos.project.action.admin.AdminPageAction;
import com.cos.project.action.admin.AdminPageProcAction;
import com.cos.project.action.admin.AdminSearchAction;
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
			return new AdminPageProcAction();
		}else if(cmd.equals("search")) {
			return new AdminSearchAction();
		}else if(cmd.equals("detailsearch")) {
			return new AdminDetailSearchAction();
		}else if(cmd.equals("update")) {
			return new AdminUpdateAction();
		}
		return null;
	}

}
