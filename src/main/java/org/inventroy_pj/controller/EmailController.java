package org.inventroy_pj.controller;

import org.inventory_pj.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/mail")
	public String sendMail(@RequestParam("recipient") String recipient, @RequestParam("subject") String subject, @RequestParam("content") String content) {
		emailService.sendMail(recipient, subject, content);

		return "redirect:/"; // 성공 페이지로 리다이렉트
	}

}
