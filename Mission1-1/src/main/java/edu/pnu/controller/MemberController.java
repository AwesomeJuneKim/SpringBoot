package edu.pnu.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {
	HashMap<Integer, MemberVO> memberMap;
	
	public MemberController() {
		memberMap = new HashMap<Integer,MemberVO>();
		for(int i=1;i<=10;i++) {
			MemberVO member = MemberVO.builder()
									.id(i)
									.name("name"+i)
									.pass("pass"+i)
									.regidate(new Date())
									.build();
			memberMap.put(i,member);
		}
	}
	//Read all
	@GetMapping("/members")
	public Collection<MemberVO> getMembers() {
		return memberMap.values();
	}
	//Read individually
	@GetMapping("/member")
	public MemberVO getMember(Integer id){
		for(MemberVO member : memberMap.values()) {
			if(member.getId()==id) {
				return member;
			}
		}
		return null;
	}
	//Create
	@PostMapping
	public MemberVO addMember(MemberVO memberVO) {
		if(getMember(mem))
	}
	
}
