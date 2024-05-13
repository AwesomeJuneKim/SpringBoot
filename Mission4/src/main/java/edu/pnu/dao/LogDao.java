package edu.pnu.dao;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.LogDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LogDao {
	private final DataSource dataSource;
	
	public int addLog(LogDTO l) {
		PreparedStatement psmt = null;
		String query = "insert into dblog(method, sqlstring, success) values(?,?,?)";
		int result;
		try {
			psmt = dataSource.getConnection().prepareStatement(query);
			psmt.setString(1, l.getMethod());
			psmt.setString(2, l.getSqlstring());
			psmt.setBoolean(3, l.isSuccess());
			result = psmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
