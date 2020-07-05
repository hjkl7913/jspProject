package com.cos.project.util;

import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAnswer {

	public static int  AdminEmailAnswer(String displayName,String email, String question,String writeDate,String answer) {
		final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩

		String subject = "안녕하세요 에픽게임즈입니다.";
		String fromEmail = "보내는 이메일 주소";  // 보내는 이메일 주소
		String fromUsername = "SYSTEM MANAGER";
		String toEmail = email; // 콤마(,)로 여러개 나열 //받는 이메일 주소

		final String username = "구글 이메일 아이디"; // 구글 이메일 아이디
		final String password = "발급받은 앱 비밀번호"; // 발급받은 앱 비밀번호

		// 메일에 출력할 텍스트
		StringBuffer sb = new StringBuffer();
		sb.append("<h3>안녕하세요 에픽게임즈 입니다.</h3>\n");
		sb.append("<h4>해당내용 답변입니다.</h4>\n");
		sb.append("<p>유저네임: "+displayName+" </p>\n");
		sb.append("<p>작성 날짜: "+writeDate+ "</p>\n");
		sb.append("<p>문의 내용</p>\n\n\n");
		sb.append("<p>"+question+"</p>\n\n\n");
		sb.append("<p>답변 내용</p>\n");
		sb.append("<p>"+answer+ "</p>\n");

		String html = sb.toString();

		// 메일 옵션 설정
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
			// 메일 서버 인증 계정 설정
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};

			// 메일 세션 생성
			Session session = Session.getInstance(props, auth);

			// 메일 송/수신 옵션 설정
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail, fromUsername));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
			message.setSubject(subject);
			message.setSentDate(new Date());

			// 메일 콘텐츠 설정
			Multipart mParts = new MimeMultipart();
			MimeBodyPart mTextPart = new MimeBodyPart();
			MimeBodyPart mFilePart = null;

			// 메일 콘텐츠 - 내용
			mTextPart.setText(html, bodyEncoding, "html");
			mParts.addBodyPart(mTextPart);

			// 메일 콘텐츠 설정
			message.setContent(mParts);

			// MIME 타입 설정
			MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(MailcapCmdMap);

			// 메일 발송
			Transport.send(message);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserPasswordEmailSendAction : 이메일보내기 오류 : "+e.getMessage());
			
		}
		
		return -1;
	}
}

