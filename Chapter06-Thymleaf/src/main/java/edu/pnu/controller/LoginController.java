package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;
@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService ms;
	@GetMapping("/login")
	public void loginView() {
	}
	@PostMapping("/login")
	public String login(Member mb, Model ml) {
		Member findMember= ms.getMember(mb);
		
		if(findMember != null
				&& findMember.getPassword().equals(mb.getPassword())) {
			ml.addAttribute("member",findMember);
			return "redirect:getBoardList";
		}else {
			return "redirect:login";
		}
	}
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
}
