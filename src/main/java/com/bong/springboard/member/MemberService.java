package com.bong.springboard.member;

import com.bong.springboard.member.dto.MemberDTO;

public interface MemberService {
	/** 로그인 정보 조회 */
	MemberDTO login(MemberDTO memberDTO);
}
