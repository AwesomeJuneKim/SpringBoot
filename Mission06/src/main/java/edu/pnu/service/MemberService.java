package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	public List<Member> getMembers(){
		return memberRepo.findAll();
	}
	
	
	public Member getMember(String id) {
		return memberRepo.findById(id).get();
	}
	
	public int insertMember(Member m) {
		memberRepo.save(m);
		
		return 1;
	}
	
	public int updateMember(Member m) {
		try {
			Optional<Member> preM = memberRepo.findById(m.getId());
			if(preM.isPresent()) {
				Member editM = preM.get();
				if(m.getPassword()!=null)
					editM.setPassword(m.getPassword());
				if(m.getName()!=null)
					editM.setName(m.getName());
				if(m.getRole()!=null)
					editM.setRole(m.getRole());
				
				memberRepo.save(editM);
				return 1;
			}
			else
				return 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int deleteMember(String id) {
		memberRepo.deleteById(id);
		return 1;
	}
}
