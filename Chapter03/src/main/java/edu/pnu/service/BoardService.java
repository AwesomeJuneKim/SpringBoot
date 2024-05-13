package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
