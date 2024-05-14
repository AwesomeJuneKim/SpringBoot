package edu.pnu.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.LogDTO;
import edu.pnu.domain.MemberVO;

@Component
public class MemberService {
	@Autowired
	MemberDao dao;
	@Autowired
	LogDao ldao;
	
	
	public List<MemberVO> getMembers () {
		Map<String, Object> map= dao.getMembers();
		List<MemberVO> list = null;
		LogDTO log= new LogDTO();
		String method=(String)map.get("method");
		String query = (String)map.get("sqlstring");
		Boolean flag = (Boolean)map.get("success");
		try {
			log.setMethod(method);
			log.setSqlstring(query);
			log.setSuccess(flag);
			ldao.addLog(log);
			list=(List<MemberVO>) map.get("list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public MemberVO getMember(Integer id) throws SQLException {
		Map<String, Object> map = dao.getMember(id);
		LogDTO log= new LogDTO();
		String method=(String)map.get("method");
		String query=(String)map.get("sqlstring");
		Boolean flag=(Boolean)map.get("flag");
		try {
			log.setMethod(method);
			log.setSqlstring(query);
			log.setSuccess(flag);
			ldao.addLog(log);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (MemberVO) map.get("memberVO");
	}
	public int insertMethod(MemberVO memberVO) throws SQLException {
		Map<String, Object> map=dao.insertMethod(memberVO);
		LogDTO log= new LogDTO();
		String method=(String)map.get("method");
		String query=(String)map.get("sqlstring");
		Boolean flag=(Boolean)map.get("flag");
		try {
			log.setMethod(method);
			log.setSqlstring(query);
			log.setSuccess(flag);
			ldao.addLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (int) map.get("result");
	}
	public int memberUpdate(MemberVO memberVO) throws SQLException {
		Map<String, Object> map = dao.memberUpdate(memberVO);
		LogDTO log= new LogDTO();
		String method=(String)map.get("method");
		String query=(String)map.get("sqlstring");
		Boolean flag=(Boolean)map.get("flag");
		try {
			log.setMethod(method);
			log.setSqlstring(query);
			log.setSuccess(flag);
			ldao.addLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (int) map.get("result");
	}
	public int memberDelete(Integer id) throws SQLException {
		Map<String, Object> map = dao.memberDelete(id);
		LogDTO log= new LogDTO();
		String method=(String)map.get("method");
		String query=(String)map.get("sqlstring");
		Boolean flag=(Boolean)map.get("flag");
		try {
			log.setMethod(method);
			log.setSqlstring(query);
			log.setSuccess(flag);
			ldao.addLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (int) map.get("result");
	}
	
}
