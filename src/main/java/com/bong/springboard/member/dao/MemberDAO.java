package com.bong.springboard.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.bong.springboard.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	/** 로그인 정보 조회 */
	MemberDTO selectMemberByLoginId(String loginId);
}
