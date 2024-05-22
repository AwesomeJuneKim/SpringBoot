package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
//	@Query(value = "select b.seq, b.title, b.content, b.createDate, b.cnt, m.name from board b , member m where b.seq=?1 and b.writer=m.id", nativeQuery = true)
//	Object[] getBoardDTO(Long seq);
}
