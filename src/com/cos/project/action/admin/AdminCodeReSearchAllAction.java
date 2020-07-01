package com.cos.project.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.cos.project.action.Action;
import com.cos.project.model.GameCode;
import com.cos.project.model.UsedGameCode;
import com.cos.project.repository.GameInfoRepository;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.Script;
import com.google.gson.Gson;

public class AdminCodeReSearchAllAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GameInfoRepository gameInfoRepository = GameInfoRepository.getInstance();
		
		List<GameCode> gameCodes = gameInfoRepository.AdminCodeSearchAll();
		
		Gson gson = new Gson();
		
		String gameCodesJasons = gson.toJson(gameCodes);
		
		Script.outJson(gameCodesJasons, response);
	}
}
