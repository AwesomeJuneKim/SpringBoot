package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	//jpa가 인터페이스의 메서드를 자동으로 생성해서 컨테이너에 올려주기 때문에 어노테이션을 입력할 필요가 없다.
	
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
}
