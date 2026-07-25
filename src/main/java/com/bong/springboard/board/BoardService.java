package com.bong.springboard.board;

import java.util.List;
import com.bong.springboard.board.dto.BoardDTO;

public interface BoardService {
    /**
     * 게시글 목록 조회
     * 추후 페이징을 위하여 Map으로 반환타입 변환 예정
     */
    List<BoardDTO> getBoardList();
    /**
     * 게시글 상세 조회
     */
    BoardDTO getBoard(Long boardId);
    /** 게시글 등록*/
    int insertBoard(BoardDTO boardDTO);
    /** 게시글 수정 */
    int updateBoard(BoardDTO boardDTO);
    /** 게시글 삭제 */ 
    int deleteBoard(BoardDTO boardDTO);
}
