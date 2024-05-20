package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@GetMapping("/members")
	public List<Member> getBoards(){
		return ms.getMembers();
	}
	
	@GetMapping("/member")
	public Member getMember(String id) {
		return ms.getMember(id);
	}
	@PostMapping("/member")
	public int insertBoard(Member m) {
		ms.insertMember(m);
		
		return 1;
	}
	@PutMapping("/member")
	public int updateBoard(Member m) {
		ms.updateMember(m);
			return 1;
	
	}
	@DeleteMapping("/member")
	public int deleteBoard(String id) {
		ms.deleteMember(id);
		return 1;
	}
}
