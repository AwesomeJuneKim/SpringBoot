package edu.pnu;

import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationRunner {
	private final MemberRepository memberRepo;
	private final BoardRepository boardRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 1; i <= 5; i++) {
			Member m = Member.builder().id("id"+i).password("password"+i).name("tester"+i).role("test_role"+i).build();
			memberRepo.save(m);

			Random rd = new Random();
			for (int j = 1; j <= 5; j++) {
				boardRepo.save(Board.builder().title("title" + j).content("content" + j).createDate(new Date())
						.cnt(Math.abs(rd.nextLong() % 100)).member(m).build());
			}
		}

	}
}
