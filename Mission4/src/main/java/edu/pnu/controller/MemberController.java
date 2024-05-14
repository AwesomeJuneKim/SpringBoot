package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService ms;

	@GetMapping("/members")
	public List<MemberVO> getMembers(MemberVO memberVO) throws SQLException {
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
	public int memberUpdate(MemberVO memberVO) throws SQLException {
		return ms.memberUpdate(memberVO);
	}

	@DeleteMapping("/member")
	public int memberDelete(Integer id) throws SQLException {
		return ms.memberDelete(id);

	}
}
