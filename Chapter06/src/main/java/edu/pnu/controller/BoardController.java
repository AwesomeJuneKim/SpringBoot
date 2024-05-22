package edu.pnu.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board b) {
		
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
	public String insertBoardView() {
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board b) {
		bs.insertBoard(b);
		return "redirect:getBoardList";
	}
	@GetMapping("/getBoard")
	public String getBoard(Board b, Model m) {
		m.addAttribute("board", bs.getBoard(b));
		return "getBoard";
	}
	@PostMapping("/updateBoard")
	public String updateBoard(Board b) {
		bs.updateBoard(b);
		return "redirect:getBoardList";
	}
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board b) {
		bs.deleteBoard(b);
		return "forward:getBoardList";
	}
}
