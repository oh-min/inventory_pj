package org.inventory_pj.service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {
	private String host = "smtp.naver.com"; // SMTP 서버
	private String username = "ohhyemin96@naver.com"; // 발신자 이메일
	private String password = "szsz0131@"; // 발신자 비밀번호

	public void sendMail(String to, String subject, String content) {
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true"); // 인증 사용
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465"); // SSL 포트
        props.put("mail.smtp.ssl.enable", "true"); // SSL 사용
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
