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

		// service�� �ѱ� id, pw�� �̿��Ͽ� select�Ǿ� �Ѿ�� ���� session�� ����
		session.setAttribute("user", ms.signin(mvo));
		session.setMaxInactiveInterval(60 * 60); // session�� 60�� ���� ���� (���Ѵ� : -1)

		try {
			// ȸ�� ������ �ִ� ���
			if (ms.signin(mvo) != null) {
				System.out.println("유저이름 비밀번호 일치.");
				System.out.println("저장된 유저이름 : " + ms.signin(mvo).getUsername());
				System.out.println("저장된 비밀번호 : " + ms.signin(mvo).getPw());
				// �����̸��� ��й�ȣ ��� ��ġ�ϴ� ���
				if (mvo.getUsername().equals(ms.signin(mvo).getUsername()) && mvo.getPw().equals(ms.signin(mvo).getPw())) {

					System.out.println(session.getAttribute("user"));

					return "redirect:/";
				} else if (mvo.getUsername().equals(ms.signin(mvo).getUsername())) { // �����̸��� ��ġ, ��й�ȣ ����ġ�ϴ� ���
					try {
						response.setContentType("text/html; charset=utf-8");
						PrintWriter w = response.getWriter();
						w.write("<script>alert('저장된 정보와 일치하지 않습니다.');window.history.back();</script>");
						w.flush();
						w.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				// ȸ�� ������ null�� ���
				System.out.println("유저이름 비밀번호 불일치.");
				try {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter w = response.getWriter();
					w.write("<script>alert('저장된 정보와 일치하지 않습니다.');window.history.back();</script>");
					w.flush();
					w.close();
					return "/home";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println("ȸ�� ���� ��ȸ �� ������ �߻��߽��ϴ�: " + e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/";
	}

	/* 로그아웃 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // �α��� ��ȿȭ
		return "redirect:/";
	}

}
