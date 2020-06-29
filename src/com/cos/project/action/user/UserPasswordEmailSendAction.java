package com.cos.project.action.user;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.repository.UsersRepository;
import com.cos.project.util.EmailSendTempPassword;
import com.cos.project.util.RandomText;
import com.cos.project.util.SHA256;
import com.cos.project.util.Script;

public class UserPasswordEmailSendAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("Email");

		String nansu = RandomText.randomTex(); // 난수뽑기
		String nansuPassword = SHA256.encodeSha256(nansu);

		System.out.println("nansu : " + nansu);

		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.tempPasswordUpdate(email, nansuPassword);

		if (result == 1) {
			int result2 = EmailSendTempPassword.SendTempPassword(email, nansu);
			if (result2 == 1) {
				Script.outText(result2+"", response);
			} else {
				Script.outText(result2+"", response);
			}
		} else {
			Script.getMessage("디비오류", response);
		}

	}

}
