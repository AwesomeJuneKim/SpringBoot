package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepo;
	
	public List<Board> getBoardList(Board b){
		return (List<Board>)boardRepo.findAll();
	}
	public Board getBoard(Board b) {
		Board b1 = boardRepo.findById(b.getSeq()).orElseThrow();
		return b1;
	}
	public void insertBoard(Board b) {
		boardRepo.save(b);
		
	}
	public void updateBoard(Board b) {
		Board findBoard = boardRepo.findById(b.getSeq()).get();
		
		findBoard.setTitle(b.getTitle());
		findBoard.setContent(b.getContent());
		boardRepo.save(findBoard);
	}
	public void deleteBoard(Board b) {
		boardRepo.deleteById(b.getSeq());
	}
}
