package com.bong.springboard.board;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bong.springboard.board.dto.BoardDTO;
import com.bong.springboard.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	/** 게시판 목록 */
	@GetMapping("/board/list")
	public String boardList(Model model) {
		List<BoardDTO> boardList = boardService.getBoardList();
		System.out.println("Controller ----------");
		System.out.println("boardList -->>" + boardList);

		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	@GetMapping("/board")
	public String board() {
		return "redirect:/board/list";
	}

	/** 게시글 상세페이지 */
	@GetMapping("/board/detail/{boardId}")
	public String boardDetail(@PathVariable("boardId") Long boardId, Model model) {
//		System.out.println("게시글 상세 페이지");
//		System.out.println("/board/detail/{boardId} ==> " + boardId);

		BoardDTO board = boardService.getBoardDetail(boardId);

		model.addAttribute("board", board);

		return "board/detail";
	}

	/** 게시글 > 등록 / 수정 페이지 */
	@GetMapping("/board/form")
	public String boardForm(@ModelAttribute("board") BoardDTO boardDTO, HttpSession session,
			RedirectAttributes redirectAttributes, Model model) {

		// 로그인 정보 조회 및 검증
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMember");

		if (memberDTO == null) {
			redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다.");
			return "redirect:/member/login";
		}

		// 등록 화면인 경우
		if (boardDTO.getBoardId() == null) {
			return "board/form";
		}

		////// 수정 화면인 경우 //////

		// 게시글 조회 및 검증
		BoardDTO originalBoard = boardService.getBoard(boardDTO.getBoardId());

		if (originalBoard == null) {
			redirectAttributes.addFlashAttribute("message", "게시글이 존재하지 않습니다.");
			return "redirect:/board/list";
		}

		// 로그인한 사용자가 작성자인지 검증
		if (!Objects.equals(memberDTO.getMemberId(), originalBoard.getWriter())) {
			redirectAttributes.addFlashAttribute("message", "잘못된 접근입니다.");
			return "redirect:/board/list";
		}

		model.addAttribute("board", originalBoard);

		return "board/form";
	}

	/** 게시글 등록 */
	@PostMapping("/board/write")
	public String boardWrite(@ModelAttribute BoardDTO boardDTO, HttpSession session,
			RedirectAttributes redirectAttributes) {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMember");
		boardDTO.setWriter(memberDTO.getMemberId());

		int result = boardService.insertBoard(boardDTO);

		if (result > 0) {
			redirectAttributes.addFlashAttribute("message", "게시글이 등록되었습니다.");
		} else {
			redirectAttributes.addFlashAttribute("message", "게시글 등록에 실패했습니다.");
		}

		return "redirect:/board/list";
	}

	/** 게시글 수정 */
	@PostMapping("/board/update")
	public String boardUpdate(@ModelAttribute BoardDTO boardDTO, HttpSession session,
			RedirectAttributes redirectAttributes) {
//		System.out.println("/board/update - boardDTO ==> "+boardDTO);

		// 로그인 정보 조회 및 검증
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMember");
		if (memberDTO == null) {
			redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다.");
			return "redirect:/member/login";
		}

		// 게시글 조회 및 검증
		BoardDTO originalBoard = boardService.getBoard(boardDTO.getBoardId());
		if (originalBoard == null) {
			redirectAttributes.addFlashAttribute("message", "게시글이 존재하지 않습니다.");
			return "redirect:/board/list";
		}

		// 로그인한 사람의 게시글인지 검증
		if (!Objects.equals(memberDTO.getMemberId(), originalBoard.getWriter())) {
			redirectAttributes.addFlashAttribute("message", "잘못된 접근입니다.");
			return "redirect:/board/list";
		}

		int result = boardService.updateBoard(boardDTO);

		if (result > 0) {
			redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
		} else {
			redirectAttributes.addFlashAttribute("message", "게시글 수정에 실패했습니다.");
		}

		return "redirect:/board/detail/" + boardDTO.getBoardId();
	}

	/** 게시글 삭제 */
	@PostMapping("/board/delete")
	public String boardDelete(@ModelAttribute BoardDTO boardDTO, HttpSession session,
			RedirectAttributes redirectAttributes) {

		// 로그인 정보 조회 및 검증
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMember");
		if (memberDTO == null) {
			redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다.");
			return "redirect:/member/login";
		}

		// 게시글 조회 및 검증
		BoardDTO originalBoard = boardService.getBoard(boardDTO.getBoardId());
		if (originalBoard == null) {
			redirectAttributes.addFlashAttribute("message", "게시글이 존재하지 않습니다.");
			return "redirect:/board/list";
		}

		// 로그인한 사람의 게시글인지 검증
		if (!Objects.equals(memberDTO.getMemberId(), originalBoard.getWriter())) {
			redirectAttributes.addFlashAttribute("message", "잘못된 접근입니다.");
			return "redirect:/board/list";
		}

		int result = boardService.deleteBoard(boardDTO);

		if (result > 0) {
			redirectAttributes.addFlashAttribute("message", "게시글이 삭제되었습니다.");
		} else {
			redirectAttributes.addFlashAttribute("message", "게시글 삭제에 실패했습니다.");
		}

		return "redirect:/board/list";
	}

}
