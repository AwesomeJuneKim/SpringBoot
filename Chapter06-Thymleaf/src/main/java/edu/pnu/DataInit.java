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
	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		memberRepo.save(Member.builder().id("member1").password("abcd").name("둘리").role("ROLE_USER").build());
		memberRepo.save(Member.builder().id("member2").password("abcd").name("도우너").role("ROLE_ADMIN").build());
		
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
