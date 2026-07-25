package com.bong.springboard.member;

import org.springframework.stereotype.Service;

import com.bong.springboard.member.dao.MemberDAO;
import com.bong.springboard.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO memberDAO;

	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberDAO.selectMemberByLoginId(memberDTO.getLoginId());
		
		// 아이디 없음
		if(loginMember == null) return null;
		
		// 비밀번호 불일치
		if(!loginMember.getPassword().equals(memberDTO.getPassword())) {
			return null;
		}
		
		// 로그인 성공
		return loginMember;
	}

}
