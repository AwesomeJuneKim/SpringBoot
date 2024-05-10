package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	List<MemberVO>list;
	public MemberService() {
		list= new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(MemberVO.builder()
					.id(i)
					.name("name"+i)
					.pass("pass"+i)
					.regidate(new Date())
					.build());
		}
	}
	//Read all
	public List<MemberVO> getMembers(){
		return list;
	}
	//Read element
	public MemberVO getMember(Integer id) {
		for(MemberVO m:list) {
			if(m.getId()==id) return m;
		}
		return null;
	}
	//Create
	public MemberVO addMember(MemberVO memberVO) {
		if(getMember(memberVO.getId())!=null)
			return null;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	//Update
	public int updateMethod(MemberVO memberVO) {
		MemberVO m=getMember(memberVO.getId());
		if(m==null)
			return 0;
		if(m.getName()!=null)
			m.setName(memberVO.getName());
		if(m.getPass()!=null)
			m.setPass(memberVO.getPass());
		return 1;
		
	}
	//Delete
	public int deleteMethod(Integer id) {
		try {
			list.remove(getMember(id));
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}
}
