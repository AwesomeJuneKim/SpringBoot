package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;



@RestController
public class MemberController {
	List<MemberVO> memberList;
	public MemberController() {
		
		memberList = new ArrayList<MemberVO>();
		for(int i=1; i<=10;i++) {
//			MemberVO member = new MemberVO();
//			member.setId(i);
//			member.setPass("pass"+i);
//			member.setName("Tester"+i);
//			member.setRegidate(new Date());
//			memberList.add(member);
			
			//빌더 방식으로 객체 만드는 방법
			memberList.add(MemberVO.builder()
					.id(i)
					.name("name"+i)
					.pass("pass"+i)
					.regidate(new Date())
					.build());
		}
	}
	//Read all
	@GetMapping("/members")
	public List<MemberVO> getMembers() {
		return memberList;
	}
	//해당코드와 위의 코드 둘 중 하나만 써야한다, 해당코드가 더 나음
	@GetMapping("/members")
	public ResponseEntity<?> getAllMembers(){
		return ResponseEntity.ok(memberList);
	}
	
	//Read individually
	@GetMapping("/member")
	public MemberVO getMember(Integer id) {
		for(MemberVO member : memberList) {
			if(member.getId()==id) {
				return member;
			} 
		}
		return null;
		
	}
	//Create
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		if(getMember(memberVO.getId())!=null)//입력할 id가 memberList의 id와 중복이면 return null
			return null;
		memberVO.setRegidate(new Date());
		memberList.add(memberVO);
		return memberVO;
	}
	@PostMapping("/memberJSON")
	public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {//바디에서 제이슨파일을 백엔드로 보냄
		if(getMember(memberVO.getId())!=null)
			return null;
		memberVO.setRegidate(new Date());
		memberList.add(memberVO);
		return memberVO;
	}
	//Update
	@PutMapping("/member")
	public int putMethodName(MemberVO memberVO) {
		MemberVO m = getMember(memberVO.getId());
		if(m==null)
			return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}
	//Delete
	@DeleteMapping("/member")
	public int removeMember(Integer id) {
		try {
			memberList.remove(getMember(id));
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
	
	
}
