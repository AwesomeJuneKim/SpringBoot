package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@BeforeEach //메서드마다 따로 계속 실행 된다.
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
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("--->" +board.toString());
//		}
//		
//	}
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList= boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("-->"+board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleContaining() {
//		List<Board> boardList=boardRepo.findByTitleContaining("1");
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
//	@Test
//	public void testFindByTitleGreaterThan() {
//		List<Board> boardList=boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("-->"+board.toString());
//		}
//	}
//	@Test
//	public void testFindBetweenCntOrderByCntAsc() {
//		List<Board> boardList = boardRepo.findByCntBetweenOrderByCntAsc(10L, 50L);
//		
//		System.out.println("result");
//		for(Board b : boardList) {
//			System.out.println("-->"+b.toString());
//		}
//	}
//	@Test
//	public void testfindByTitleContainingOrContentContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
//		System.out.println("result");
//		
//		for(Board b : boardList) {
//			System.out.println("-->"+b.toString());
//		}
//	}
	//페이징 메서드
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0,5, Sort.Direction.DESC,"seq");
//		List<Board> boardList=boardRepo.findByTitleContaining("1",paging);
//		
//		System.out.println("result");
//		for(Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0,5, Sort.Direction.DESC,"seq");
		Page<Board> pageInfo=boardRepo.findByTitleContaining("title",paging);
		
		System.out.println("result");
		for(Board board : pageInfo) {
			System.out.println("--->"+board.toString());
		}
	}
}
