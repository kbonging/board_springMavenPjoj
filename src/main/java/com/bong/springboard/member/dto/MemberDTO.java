package com.bong.springboard.member.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDTO {
    /** 회원 고유번호 */
    private Long memberId;
    /** 로그인 아이디 */
    private String loginId;
    /** 비밀번호 */
    private String password;
    /** 회원 이름 */
    private String name;
    /** 회원 권한 */
    private String role;
    /** 삭제 여부 */
    private String deleteYn;
    /** 등록일시 */
    private LocalDateTime createdAt;
    /** 수정일시 */
    private LocalDateTime updatedAt;

}
