package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@BeforeEach //테
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("Test Title "+i);
			board.setWriter("tester");
			board.setContent("content"+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepo.findByTitle("Test Title 10");
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("17");
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("--->" +board.toString());
//		}
//	}
	@Test
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
		System.out.println("result");
		for(Board board : boardList) {
			System.out.println("--->" +board.toString());
		}
		
	}
}
