package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.pnu.domain.MemberVO;

@Component
public class MemberDao {
	Connection con;
	
	PreparedStatement psmt;
	public MemberDao() {
		try {
			con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg","sa","abcd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Read All
	public List<MemberVO> getMembers() throws SQLException{
		List<MemberVO> memberList = new ArrayList<>();
		Statement st=con.createStatement();
		ResultSet rs;
		try {
			rs=st.executeQuery("select * from member");
			
			while(rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setRegidate(rs.getDate("regidate"));
				
				memberList.add(m);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	//Read element
	public MemberVO getMember(Integer id) throws SQLException {
		MemberVO m=null;
		String query="select * from member where id=?";
		PreparedStatement psmt = con.prepareStatement(query);
		psmt.setInt(1, id);
		ResultSet rs=psmt.executeQuery();
		
		while(rs.next()) {
			m=new MemberVO();
			m.setId(rs.getInt(1));
			m.setName(rs.getString(2));
			m.setPass(rs.getString(3));
			m.setRegidate(rs.getDate(4));
		}
		rs.close();
		psmt.close();
		return m;
	}
	//Update
	public int updateMethod(MemberVO memberVO) throws SQLException {
		Statement st =con.createStatement();
		String str;
		if(getMember(memberVO.getId())==null)
			return 0;
		else if(memberVO.getName()!=null&&memberVO.getPass()!=null)
			str=String.format("update member set name='%s', pass='%s' where id=%s", memberVO.getName(),memberVO.getPass(),memberVO.getId());
		else if(memberVO.getName()!=null&&memberVO.getPass()==null)
			str=String.format("update member set name='%s' where id=%s", memberVO.getName(),memberVO.getId());
		else if(memberVO.getName()==null&&memberVO.getPass()!=null)
			str=String.format("update member set pass='%s' where id=%s", memberVO.getPass(),memberVO.getId());
		else
			return 0;

		int result=st.executeUpdate(str);
		st.close();
		return result;
	}
	//Delete
	public int deleteMethod(Integer id) throws SQLException {
		String del="delete from member where id=?";
		PreparedStatement psmt = con.prepareStatement(del);
		psmt.setInt(1, id);
		int result=psmt.executeUpdate();
		
		psmt.close();
		return result;
	}
	//Insert
	public int insertMethod(MemberVO memberVO) throws SQLException{
		String insert="insert into member (name,pass) values (?,?)";
		PreparedStatement psmt=con.prepareStatement(insert);
		psmt.setString(1, memberVO.getName());
		psmt.setString(2, memberVO.getPass());
		psmt.executeUpdate();
		
		return 0;
	}
	
}
