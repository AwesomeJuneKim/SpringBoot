package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "Hello : "+name;
	}

	@Override
	public BoardVO getBoard() {
		// TODO Auto-generated method stub
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("Test Title");
		board.setWriter("Tester");
		board.setContent("안녕하세요 엉인이입니다~~~^3^~~~");
		return null;
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}
