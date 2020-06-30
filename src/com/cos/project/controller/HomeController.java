package com.cos.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.action.game.GameDetailAction;
import com.cos.project.action.game.GameHomeAction;
import com.cos.project.action.game.GameKeywordSearchAction;
import com.cos.project.action.game.GameSearchAction;
import com.cos.project.action.game.GameTagSearchAction;
import com.cos.project.action.game.HomeNewsAction;
import com.cos.project.action.game.HomeQuestionAction;
import com.cos.project.action.game.HomeSearchProcAction;



@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final String TAG = "AdminController : ";
	private static final long serialVersionUID = 1L;
       
    
    public HomeController() {
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
		if(cmd.equals("home")) { // nav바 스토어 클릭했을때
			return new GameHomeAction();
		}else if(cmd.equals("detail")) { //home 에서 게임 클릭했을때
			return new GameDetailAction();
		}else if(cmd.equals("question")) { // home 에서 자주묻는질문 클릭했을때
			return new HomeQuestionAction();
		}else if(cmd.equals("search")) { // home 에서 찾아보기 클릭 했을때
			return new GameSearchAction();
		}else if(cmd.equals("tagSearch")) { // home 에서 키워드로 검색 했을때 나오는 페이지 태그로 분류 검색
			return new GameTagSearchAction();
		}else if(cmd.equals("homeGameSearch")) { // home 에서 키워드로 검색 했을때
			return new HomeSearchProcAction();
		}else if(cmd.equals("keywordSearch")) { // home 에서 키워드로 검색 했을때 나오는 페이지에서 키워드로 검색 했을때
			return new GameKeywordSearchAction();
		}else if(cmd.equals("news")) {	// nav바 새소식 클릭했을때
			return new HomeNewsAction();
		}
		return null;
		}
	
}
