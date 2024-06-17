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
		System.out.println("�Է¹��� �����̸� : " + mvo.getUsername());
		System.out.println("�Է¹��� ��й�ȣ : " + mvo.getPw());

		// service�� �ѱ� id, pw�� �̿��Ͽ� select�Ǿ� �Ѿ�� ���� session�� ����
		session.setAttribute("user", ms.signin(mvo));
		try {
			// ȸ�� ������ �ִ� ��� 
			if (ms.signin(mvo) != null) {
				System.out.println("��� ����� �����̸� : " + ms.signin(mvo).getUsername());
				System.out.println("��� ����� ��й�ȣ : " + ms.signin(mvo).getPw());
				// �����̸��� ��й�ȣ ��� ��ġ�ϴ� ���
				if (mvo.getUsername().equals(ms.signin(mvo).getUsername()) && mvo.getPw().equals(ms.signin(mvo).getPw())) {
					System.out.println("�α��� ����");
					return "redirect:/";
				} else if (mvo.getUsername().equals(ms.signin(mvo).getUsername())) { // �����̸��� ��ġ, ��й�ȣ ����ġ�ϴ� ���
					try {
						response.setContentType("text/html; charset=utf-8"); 
						PrintWriter w = response.getWriter();
						w.write("<script>alert('��й�ȣ�� �߸� �Է��߽��ϴ�.');location.href='/';</script>");
						w.flush(); 
						w.close(); 
						return "/home"; 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				// ȸ�� ������ null�� ��� 
				System.out.println("ȸ�� ������ �����ϴ�."); 
				try {
					response.setContentType("text/html; charset=utf-8"); 
					PrintWriter w = response.getWriter();
					w.write("<script>alert('ȸ�� ������ �����ϴ�.');location.href='/';</script>");
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

}
