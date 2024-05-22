package edu.pnu.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;
@SessionAttributes("member")
//컨트롤러 안에서 멤버라는 이름으로 모델에 저장하면 자동으로 세션에 저장되게하는 어노테이션
@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	//모델객체를 멤버라는 이름으로 빈객체 저장 ->로그인해서 로그인 컨트롤러에서 생성된 객체를 갖고 있으면 로그인되었음을 알수있게 해준다.
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	@GetMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model , Board b) {
		//@ModelAttribute("member") 멤버라는 모델객체에 아무것도 없을경우를 확인하기 위해서
		if(member.getId() ==null) {
			return "redirect:login";
		}
		
		List<Board> boardList = bs.getBoardList(b);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
		
//		List<Board> boardList = new ArrayList<>();
//		for(long i=1L;i<=10L;i++) {
//			boardList.add(Board.builder()
//					.seq(i)
//					.title("board program test"+i)
//					.writer("tester"+i)
//					.content("does this work?")
//					.build());
//		}
//		model.addAttribute("boardList",boardList);
//		return "getBoardList";
	}
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board b) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		bs.insertBoard(b);
		return "redirect:getBoardList";
	}
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board b, Model m) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		m.addAttribute("board", bs.getBoard(b));
		return "getBoard";
	}
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board b) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		bs.updateBoard(b);
		return "redirect:getBoardList";
	}
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board b) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		bs.deleteBoard(b);
		return "forward:getBoardList";
	}
}
