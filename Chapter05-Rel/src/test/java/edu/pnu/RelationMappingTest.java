package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;

	@Test
	public void testManyToOneSelect() {
		Board b = boardRepo.findById(5L).get();
		System.out.println("[" + b.getSeq() + "번 게시글 정보" + "]");
		System.out.println("제목 : " + b.getTitle());
		System.out.println("내용 : " + b.getContent());
		System.out.println("작성자 : " + b.getMember().getName());
		System.out.println("작성자 권한 : " + b.getMember().getRole());
		System.out.println();
		System.out.println("[" + b + "]");
	}
	@Test
	public void testTwoWayMapping() {
		Member m= memberRepo.findById("member1").get();
		System.out.println("============================");
		System.out.println(m.getName()+"가(이) 저장한 게시글 목록");
		System.out.println("============================");
		List<Board> list = m.getBoardList();
		for(Board b : list) {
			System.out.println(b.toString());
		}
	}
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}

}
