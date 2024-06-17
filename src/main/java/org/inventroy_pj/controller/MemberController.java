package org.inventroy_pj.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.inventory_pj.model.MemberVO;
import org.inventory_pj.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO mvo, HttpSession session, HttpServletResponse response) {
		System.out.println("입력받은 유저이름 : " + mvo.getUsername());
		System.out.println("입력받은 비밀번호 : " + mvo.getPw());

		// service로 넘긴 id, pw를 이용하여 select되어 넘어온 값을 session에 저장
		session.setAttribute("user", ms.signin(mvo));
		try {
			// 회원 정보가 있는 경우 
			if (ms.signin(mvo) != null) {
				System.out.println("디비에 저장된 유저이름 : " + ms.signin(mvo).getUsername());
				System.out.println("디비에 저장된 비밀번호 : " + ms.signin(mvo).getPw());
				// 유저이름과 비밀번호 모두 일치하는 경우
				if (mvo.getUsername().equals(ms.signin(mvo).getUsername()) && mvo.getPw().equals(ms.signin(mvo).getPw())) {
					System.out.println("로그인 성공");
					return "redirect:/";
				} else if (mvo.getUsername().equals(ms.signin(mvo).getUsername())) { // 유저이름은 일치, 비밀번호 불일치하는 경우
					try {
						response.setContentType("text/html; charset=utf-8"); 
						PrintWriter w = response.getWriter();
						w.write("<script>alert('비밀번호를 잘못 입력했습니다.');location.href='/';</script>");
						w.flush(); 
						w.close(); 
						return "/home"; 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				// 회원 정보가 null인 경우 
				System.out.println("회원 정보가 없습니다."); 
				try {
					response.setContentType("text/html; charset=utf-8"); 
					PrintWriter w = response.getWriter();
					w.write("<script>alert('회원 정보가 업습니다.');location.href='/';</script>");
					w.flush(); 
					w.close(); 
					return "/home"; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println("회원 정보 조회 중 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/";
	}

}
