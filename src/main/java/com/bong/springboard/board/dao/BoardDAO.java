package com.bong.springboard.board.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bong.springboard.board.dto.BoardDTO;

@Mapper
public interface BoardDAO {
    /** 게시글 전체 조회 */
    List<BoardDTO> selectBoardList();
    /** 게시글 조회 */
    BoardDTO selectBoard(Long boardId);
    /** 조회수 증가*/
    void updateViewCount(Long boardId);
    /** 게시글 등록*/
    int insertBoard(BoardDTO boardDTO);
	/** 게시글 수정 */
    int updateBoard(BoardDTO boardDTO);
    /** 게시글 삭제 */ 
    int deleteBoard(BoardDTO boardDTO);
}
