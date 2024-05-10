package edu.pnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	MemberDao dao;
	public MemberService() {
		dao= new MemberDao();
	}
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