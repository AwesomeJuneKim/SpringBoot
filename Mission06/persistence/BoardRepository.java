package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	//jpa가 인터페이스의 메서드를 자동으로 생성해서 컨테이너에 올려주기 때문에 어노테이션을 입력할 필요가 없다.

	//인터페이스에서 제공하는 메서드외에 다른 메서드를 만들어서 사용하고 싶다면 쿼리메서드를 작성한다.
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	List<Board> findByTitleContaining(String searchKeyword);
	//select *
	//from board
	//where title containing "title" and cnt>50
	List<Board> findByTitleContainingAndCntGreaterThan(String title, Long cnt);
	//select * 
	//from board 
	//where (cnt between s and e) and title containing "title" 
	//order by cnt asc
	List<Board> findByCntBetweenOrderByCntAsc(Long start, Long end);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	//페이징 처리
	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	//쿼리에 파라미터가가 여러개 들어갈 수 있으므로 ?숫자를 입력해 준다.
	//@Query("select b from Board b where b.title like %?1% order by b.seq desc")//Board는 클래스이름이라서 대소문자 구분한다.
//	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
//	List<Board> queryAnnotationTest1(String searchKeyword);
//	//검색 후 여러객체를 배열로 받음
//	@Query("select b.seq, b.title, b.writer, b.createDate from Board b where b.title like %?1% order by b.seq desc")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
//	
//	@Query(value="select seq, title, writer, create_date from board where title like '%'||?1||'%' order by seq desc", nativeQuery=true)
//	List<Object[]> queryAnnotationTest3(String searchKeyword);
}
