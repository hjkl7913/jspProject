package com.cos.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.action.user.UserPasswordEmailSendAction;
import com.cos.project.action.user.UsersAcountAction;
import com.cos.project.action.user.UsersAcountCartAction;
import com.cos.project.action.user.UsersAcountPasswordAction;
import com.cos.project.action.user.UsersAcountUpdateAction;
import com.cos.project.action.user.UsersCartAddAction;
import com.cos.project.action.user.UsersCartAddCheckAction;
import com.cos.project.action.user.UsersCartDeleteAction;
import com.cos.project.action.user.UsersCartReSearchAction;
import com.cos.project.action.user.UsersCodePageAction;
import com.cos.project.action.user.UsersEmailCheckAction;
import com.cos.project.action.user.UsersFindPasswordAction;
import com.cos.project.action.user.UsersGameBuyAction;
import com.cos.project.action.user.UsersGameBuyCheckAction;
import com.cos.project.action.user.UsersGameBuyCountAction;
import com.cos.project.action.user.UsersJoinAction;
import com.cos.project.action.user.UsersJoinProcAction;
import com.cos.project.action.user.UsersLoginAction;
import com.cos.project.action.user.UsersLoginProcAction;
import com.cos.project.action.user.UsersLogoutAction;
import com.cos.project.action.user.UsersPasswordCheckAction;
import com.cos.project.action.user.UsersPasswordUpdateAction;
import com.cos.project.action.user.UsersRefundPolicyAction;


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
		}else if(cmd.equals("account")) {
			return new UsersAcountAction();
		}else if(cmd.equals("accountUpdate")) {
			return new UsersAcountUpdateAction();
		}else if(cmd.equals("findPassword")) {
			return new UsersFindPasswordAction();
		}else if(cmd.equals("sendEmailFindPassword")) {
			return new UserPasswordEmailSendAction();
		}else if(cmd.equals("accountPassword")) {
			return new UsersAcountPasswordAction();
		}else if(cmd.equals("passwordCheck")) {
			return new UsersPasswordCheckAction();
		}else if(cmd.equals("passwordUpdate")) {
			return new UsersPasswordUpdateAction();
		}else if(cmd.equals("cartAdd")) {
			return new UsersCartAddAction();
		}else if(cmd.equals("cartAddCheck")) {
			return new UsersCartAddCheckAction();
		}else if(cmd.equals("accountCart")) {
			return new UsersAcountCartAction();
		}else if(cmd.equals("cartDelete")) {	//카트 목록 삭제
			return new UsersCartDeleteAction();
		}else if(cmd.equals("cartReSearch")) { // 카트목록 다시 불러오기
			return new UsersCartReSearchAction();
		}else if(cmd.equals("refundPolicy")) { // 환불정책 페이지
			return new UsersRefundPolicyAction();
		}else if(cmd.equals("gameBuyCount")) {	// 게임구매버튼 눌렀을때 
			return new UsersGameBuyCountAction();
		}else if(cmd.equals("gameBuyCheck")) { // 디테일 페이지에서 게임구매 버튼 눌렀을때 구매한 게임인지 체크
			return new UsersGameBuyCheckAction();
		}else if(cmd.equals("gameBuy")) { // 디테일 페이지에서 게임구매 버튼 눌렀을때 구매한 게임인지 체크
			return new UsersGameBuyAction();
		}else if(cmd.equals("accountCode")) { // 디테일 페이지에서 게임구매 버튼 눌렀을때 구매한 게임인지 체크
			return new UsersCodePageAction(); // 사용자 코드 사용 탭
		}
		
		return null;
	}

}
