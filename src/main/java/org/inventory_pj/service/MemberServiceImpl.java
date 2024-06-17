package org.inventory_pj.service;

import org.inventory_pj.mapper.MemberMapper;
import org.inventory_pj.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mm;

	// ·Î±×ÀÎ
	public MemberVO signin(MemberVO mvo) {
		return mm.signin(mvo);
	}
}
