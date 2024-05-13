package edu.pnu;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllTest {
	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void test() throws SQLException {
		List<MemberVO> list = memberDao.getMembers();
		for(MemberVO m : list) {
			System.out.println(m);
		}
	}
}
