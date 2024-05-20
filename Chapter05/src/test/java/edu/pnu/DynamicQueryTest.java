package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
@SpringBootTest
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;
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
	@Test
	public void testDynamicQuery() {
		String searchCondition = "Title";
		String searchKeyword = "Test Title 10";
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board; //pom.xml에 dependency추가 했을때 만들어 지는 클래스
		if(searchCondition.equals("Title")) {
			builder.and(qboard.title.contains(searchKeyword));
		}else if(searchCondition.equals("Content")){
			builder.and(qboard.content.like("%"+searchKeyword+"%"));
		}
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		System.out.println("result");
		for(Board board : boardList)
			System.out.println("-->"+board.toString());
	}
}
