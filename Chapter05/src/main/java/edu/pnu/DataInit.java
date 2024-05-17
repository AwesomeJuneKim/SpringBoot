package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationRunner {
	private final BoardRepository boardRepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Random rd = new Random();
		for(int i=1; i<5;i++) {
			boardRepo.save(Board.builder()
					.title("title1"+1)
					.writer("member1")
					.content("content1"+i)
					.createDate(new Date())
					.cnt(Math.abs(rd.nextLong()%100L))
					.build()
					);
		}
		for(int i=1; i<5;i++) {
			boardRepo.save(Board.builder()
					.title("title2"+i)
					.writer("member2")
					.content("content1"+i)
					.createDate(new Date())
					.cnt(Math.abs(rd.nextLong()%100L))
					.build()
					);
		}

	}

}