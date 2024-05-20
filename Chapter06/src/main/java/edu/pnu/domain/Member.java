package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity //데이터베이스와 매핑되는 클래스라고 알려줌->자동으로 만들어 줌
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@Column(name="MEMBER_ID") //조인받을 컬럼 설정
	private String id;
	private String password;
	private String name;
	private String role;
	
	//양방향 연관관계
	@ToString.Exclude //서로 불러와서 오버플로우 되는것을 방지하기 위해서 한쪽에만 설정
	@Builder.Default
	@JsonIgnore
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Board> boardList = new ArrayList<>();
	
}
