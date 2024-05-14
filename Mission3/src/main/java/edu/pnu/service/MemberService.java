package edu.pnu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDao dao;
	
	public List<MemberVO> getMembers() throws SQLException{
		return dao.getMembers();
	}
	public MemberVO getMember(Integer id) throws SQLException {
		return dao.getMember(id);
	}
	public int updateMethod(MemberVO memberVO) throws SQLException {
		return dao.updateMethod(memberVO);
	}
	public int deleteMethod(Integer id) throws SQLException {
		return dao.deleteMethod(id);
	}
	public int insertMethod(MemberVO memberVO) throws SQLException {
		return dao.insertMethod(memberVO);
	}
}
