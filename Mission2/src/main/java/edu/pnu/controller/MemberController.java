package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	private MemberService ms;
	public MemberController() {
		ms= new MemberService();
	}
	@GetMapping("/members")
	public List<MemberVO> getMembers(){
		return ms.getMembers();
	}
	@GetMapping("/member")
	public MemberVO getMember(Integer id) {
		return ms.getMember(id);
	}
	@PostMapping("/memberJSON")
	public MemberVO addMember(@RequestBody MemberVO memberVO) {
		return ms.addMember(memberVO);
	}
	@PutMapping("/memberJSON")
	public int updateMethod(@RequestBody MemberVO memberVO) {
		return ms.updateMethod(memberVO);
	}
	@DeleteMapping("/member")
	public int deleteMethod(Integer id) {
		return ms.deleteMethod(id);
	}
}
