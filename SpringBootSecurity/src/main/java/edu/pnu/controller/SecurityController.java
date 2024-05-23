package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/")
	public String index() {
		System.out.println("index");
		return "index";
	}
	@GetMapping("/member")
	public void forMember() {
		System.out.println("member");
	}
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("manager");
	}
	@GetMapping("/admin")
	public void admin() {
		System.out.println("administrator");
	}
//	@GetMapping("/loginSuccess")
//	public void loginSuccess() {
//		System.out.println("loginSuccess");
//	} loginSuccess에서 만들었으므로 삭제한다.
}
