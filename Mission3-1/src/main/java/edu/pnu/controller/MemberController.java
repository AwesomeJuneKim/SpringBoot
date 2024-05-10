package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class MemberController {
	
	//@Autowired //부트가 자동으로 컨테이너에서 memberService를 찾는다-> 찾아서 참조변수를 자동으로 넣어준다.(게터세터가 필요없다)
	private final MemberService ms;
	/*
	public MemberController() {
		System.out.println("MemberController works");
		//ms= new MemberService();
		//ms.setMemberDao(new MemberDao());
	}*/
	//@Autowired
	/*public MemberController(MemberService ms) {
		this.ms=ms;
		System.out.println("MemberController works");
	}*/
	@GetMapping("/members")
	public List<MemberVO> getMembers(MemberVO memberVO) throws SQLException{
		return ms.getMembers();
	}
	@GetMapping("/member")
	public MemberVO getMember(Integer id) throws SQLException {
		return ms.getMember(id);
	}
	@PostMapping("/member")
	public int insertMethod(MemberVO memberVO) throws SQLException {
		return ms.insertMethod(memberVO);
	}
	@PutMapping("/member")
	public int updateMethod(MemberVO memberVO) throws SQLException {
		return ms.updateMethod(memberVO);
	}
	@DeleteMapping("/member")
	public int deleteMethod(Integer id) throws SQLException {
		return ms.deleteMethod(id);
	}
}
