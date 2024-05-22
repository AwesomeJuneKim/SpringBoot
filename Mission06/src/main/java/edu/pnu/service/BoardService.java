package edu.pnu.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepo;
	
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}
	public int boardInsert(Board b) {
		b.setCreateDate(new Date());
		boardRepo.save(b);
		return 1;
	}
	public int boardUpdate(Board b) {
		Optional<Board> preB = boardRepo.findById(b.getSeq());
		if(preB.isPresent()) {
			Board editB = preB.get();
			if(b.getTitle()!=null) editB.setTitle(b.getTitle());
			if(b.getContent()!=null) editB.setContent(b.getContent());
			if(b.getCnt()!=null) editB.setCnt(b.getCnt());
			boardRepo.save(editB);
			return 1;
		}
		return 0;
	}
	public int boardDelete(Long seq) {
		boardRepo.deleteById(seq);
		return 1;
	}
}
