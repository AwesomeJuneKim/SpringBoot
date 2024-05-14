package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao {
	@Autowired
	private DataSource dataSource;

	public Map<String, Object> getMembers() {
		
		List<MemberVO> list = new ArrayList<>();
		String query ="select * from member";
		boolean flag=true;
		try {
			Statement st = dataSource.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPass(rs.getString(3));
				m.setRegidate(rs.getDate(4));

				list.add(m);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("method", "getMembers");
		map.put("sqlstring", query);
		map.put("success", flag);
		return map;

	}

	public Map<String, Object> getMember(Integer id) {
		MemberVO m = new MemberVO();
		String query="select * from member where id=";
		boolean flag=true;
		try {
			Statement st = dataSource.getConnection().createStatement();
			ResultSet rs = st.executeQuery( query + id);

			if (rs.next()) {
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPass(rs.getString(3));
				m.setRegidate(rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("memberVO", m);
		map.put("method", "getMember");
		map.put("sqlstring", query+id);
		map.put("flag", flag);
		return map;
	}
	public Map<String, Object> insertMethod(MemberVO memberVO) {
		String query="insert into member (name,pass) values (?,?)";
		int result=0;
		boolean flag=true;
		try {
			PreparedStatement psmt=dataSource.getConnection().prepareStatement(query);
			psmt.setString(1, memberVO.getName());
			psmt.setString(2, memberVO.getPass());
			result=psmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		Map<String, Object> map =new HashMap<>();
		map.put("result", result);
		map.put("method", "Insert");
		map.put("sqlstring", query);
		map.put("flag", flag);
		return map;
	}

	public Map<String, Object> memberUpdate(MemberVO m) {
		String query="UPDATE member SET ";
		boolean flag=true;
		int result=0;
		try {
			Statement st = dataSource.getConnection().createStatement();
			if(m.getName()!=null && m.getPass()!=null) {
				query += String.format("name='%s', pass='%s' where id=%d ", m.getName(),m.getPass(),m.getId());
			}
			else if(m.getName()!=null && m.getPass()==null) {
				query += String.format("name='%s' where id=%d ", m.getName(),m.getId());
			}
			else if(m.getName()==null && m.getPass()!=null) {
				query += String.format("pass='%s' where id=%d ", m.getPass(),m.getId());
			}
			
			result = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		Map<String, Object> map =new HashMap<>();
		map.put("method", "Update");
		map.put("sqlstring", query);
		map.put("result", result);
		map.put("flag", flag);
		return map;
	}

	public Map<String, Object> memberDelete(Integer id) {
		String query="delete from member where id=";
		boolean flag=true;
		int result=0;
		try {
			Statement st = dataSource.getConnection().createStatement();
			result = st.executeUpdate(query + id);
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		Map<String,Object> map = new HashMap<>();
		map.put("method", "Delete");
		map.put("sqlstring", query);
		map.put("result", result);
		map.put("flag", flag);
		return map;
	}
}
