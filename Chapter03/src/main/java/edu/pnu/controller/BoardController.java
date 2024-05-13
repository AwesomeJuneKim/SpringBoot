package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {
	@GetMapping("/hello")
	public String hello(String name) {
		log.info("name:"+name);
		return "Hello : "+name;
	}
	@GetMapping("/getBoard")
	public BoardVO getBoard() { //BoardControllerTest의 testGetBoard()에서 파라미터가 넘어오지 않으므로 빈칸으로 둔다.
		BoardVO m= new BoardVO();
		m.setWriter("Tester");
		return m;
	}

}
