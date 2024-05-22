package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

public class BoardController {
	@Autowired
	private BoardService bs;

	@GetMapping("/boards")
	public List<Board> getBoards(){
		return bs.getBoards();
	}
	
	@GetMapping("/board")
	public Board getMember(Long seq) {
		return bs.getBoard(seq);
	}
	@PostMapping("/board")
	public int insertBoard(Board b) {
		bs.boardInsert(b);
		
		return 1;
	}
	@PutMapping("/board")
	public int updateBoard(Board b) {
		bs.boardUpdate(b);
			return 1;
	
	}
	@DeleteMapping("/board")
	public int deleteBoard(Long seq) {
		bs.boardDelete(seq);
		return 1;
	}
}
