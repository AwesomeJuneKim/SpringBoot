package edu.pnu.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import edu.pnu.domain.MemberVO;

public class MemberDao {
	private DataSource dataSource;
	
	public List<MemberVO> getMembers(){
		try {
			List<MemberVO> list = new ArrayList<>();
			Statement st = dataSource.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from member");
			
			while(rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPass(rs.getString(3));
				m.setRegidate(rs.getDate(4));
				
				list.add(m);
			}
			rs.close();
			st.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public MemberVO getMember(Integer id) {
		MemberVO m=new MemberVO();
		try {
			Statement st = dataSource.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from member where id="+id);
			
			if(rs.next()) {
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPass(rs.getString(3));
				m.setRegidate(rs.getDate(4));
			}
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public int memberUpdate(MemberVO m) {
		try {
			Statement st = dataSource.getConnection().createStatement();
			String query;
			if(getMember(m.getId())==null) return 0;
			else if(m.getName()!=null && m.getPass()!=null) {
				query = String.format("update member set name=%s, pass=%s where id=%d ", m.getName(),m.getPass(),m.getId());
			}
			else if(m.getName()!=null && m.getPass()==null) {
				query = String.format("update member set name=%s where id=%d ", m.getName(),m.getId());
			}
			else if(m.getName()==null && m.getPass()!=null) {
				query = String.format("update member set pass=%s where id=%d ", m.getPass(),m.getId());
			}else
				return 0;
			int result = st.executeUpdate(query);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		public int memberDelete(Integer id) {
			try {
				Statement st = dataSource.getConnection()
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
