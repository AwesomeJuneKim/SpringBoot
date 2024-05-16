package edu.pnu.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@RestController
public class TestController {
	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("/boards")
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	
	@GetMapping("/board")
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}
	@PostMapping("/board")
	public int insertBoard(Board b) {
		b.setCreateDate(new Date());
		boardRepo.save(b);
		
		return 1;
	}
	@PutMapping("/board")
	public int updateBoard(Board b) {
		try {
			Optional<Board> preB = boardRepo.findById(b.getSeq());
			if(preB.isPresent()) {
				Board editB = preB.get();
				if(b.getTitle()!=null)
					editB.setTitle(b.getTitle());
				if(b.getContent()!=null)
					editB.setContent(b.getContent());
				if(b.getWriter()!=null)
					editB.setWriter(b.getWriter());
				if(b.getCnt()!=null)
					editB.setCnt(b.getCnt());
				
				boardRepo.save(editB);
				return 1;
			}
			else
				return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	@DeleteMapping("/board")
	public int deleteBoard(Long seq) {
		boardRepo.deleteById(seq);
		return 1;
	}
}
