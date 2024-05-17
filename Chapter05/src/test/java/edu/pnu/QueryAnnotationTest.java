package edu.pnu;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@SpringBootTest
public class QueryAnnotationTest {
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
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotationTest1("Test Title 10");
//		System.out.println("result");
//		
//		for(Board b : boardList) {
//			System.out.println("-->"+b.toString());
//		}
//	}
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("Test Title 10");
//		System.out.println("result");
//		
//		for(Object[] row : boardList) {
//			System.out.println("-->"+Arrays.toString(row));
//		}
//	}
	@Test
	public void testQueryAnnotation3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("Test Title 10");
		System.out.println("result");
		
		for(Object[] row : boardList) {
			System.out.println("-->"+Arrays.toString(row));
		}
	}
}
