package com.bong.springboard.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bong.springboard.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
private final MemberService memberService;
	
	@GetMapping("/member/login")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
    public String login(MemberDTO memberDTO,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {

        MemberDTO loginMember = memberService.login(memberDTO);
 
        if(loginMember == null) {
            redirectAttributes.addFlashAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");

            return "redirect:/member/login";
        }
        loginMember.setPassword(null);

        session.setAttribute("loginMember", loginMember);

        return "redirect:/board/list";
    }
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/member/login";
	}

}
