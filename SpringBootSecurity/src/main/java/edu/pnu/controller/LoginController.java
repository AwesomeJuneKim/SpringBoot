package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	private MemberService ms;
	@GetMapping("/login")
	public void login() {
		System.out.println("login");
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		System.out.println("loginSuccess requested");
	}
	@GetMapping("/accessDenied")
	public void accessDenied() {
		System.out.println("accessDenied");
	}
	@GetMapping("/auth")
	public @ResponseBody String auth(@AuthenticationPrincipal User user) {
		return user.toString();
	}
	@GetMapping("/join")
	public void join() {
		
	}
	@PostMapping("/join")
	public String joinpoc(Member member) {
		ms.save(member);
		return "welcome";
	}
}
