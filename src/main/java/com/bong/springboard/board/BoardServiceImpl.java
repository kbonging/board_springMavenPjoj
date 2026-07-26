package com.bong.springboard.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bong.springboard.board.dao.BoardDAO;
import com.bong.springboard.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardDAO boardDAO;
	
    /** 게시글 전체 목록 조회 */
    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> result = boardDAO.selectBoardList();
        return result;
    }

    /** 게시물 조회 */
    @Override
    public BoardDTO getBoard(Long boardId) {
        return boardDAO.selectBoard(boardId);
    }

    /** 게시글 상세페이지 조회*/
    @Override
    public BoardDTO getBoardDetail(Long boardId) {
    	// 조회수 증가
    	boardDAO.updateViewCount(boardId);
    	return boardDAO.selectBoard(boardId);
    }
    
	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return boardDAO.insertBoard(boardDTO);
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return boardDAO.updateBoard(boardDTO);
	}

	@Override
	public int deleteBoard(BoardDTO boardDTO) {
		return boardDAO.deleteBoard(boardDTO);
	}

}
