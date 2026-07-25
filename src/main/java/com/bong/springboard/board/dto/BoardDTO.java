package com.bong.springboard.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDTO {
    /** 게시글 번호 */
    private Long boardId;
    /** 게시글 제목 */
    private String title;
    /** 게시글 내용 */
    private String content;
    /** 작성자 회원 번호(FK) */
    private Long writer;
    /** 조회수 */
    private int viewCnt;
    /** 삭제 여부 */
    private String deleteYn;
    /** 등록일시 */
    private LocalDateTime createdAt;
    /** 수정일시 */
    private LocalDateTime updatedAt;

    // JOIN 조회용
    /** 작성자 이름 */
    private String writerName;
}
