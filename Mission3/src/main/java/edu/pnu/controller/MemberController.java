package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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